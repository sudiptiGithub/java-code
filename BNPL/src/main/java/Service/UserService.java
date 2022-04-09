package Service;

import Exceptions.PaymentNotAllowedException;
import Exceptions.ProductDoNotExistsException;
import Model.*;
import Repo.Inventory;
import Repo.UserDao;
import Comparator.DateComparator;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class UserService {

    Inventory inventory = Inventory.getINSTANCE();

    UserDao userDao = UserDao.getINSTANCE();

    public UUID buy(String name, String orderDate, List<Items> orderItems, PaymentMethod paymentMethod) {
        Order order = null;
        if (!orderItemsExistInInventory(orderItems)) {
            throw new ProductDoNotExistsException("Item is out of stock");
        }
        if (paymentMethod.equals(PaymentMethod.PREPAID)) {
            order = new Order(UUID.randomUUID(), orderDate, orderItems, PaymentMethod.PREPAID, PaymentStatus.COMPLETED);
            prepaidOrder(name, orderDate, orderItems, order);
        } else if (paymentMethod.equals(PaymentMethod.BNPL)) {
            order = new Order(UUID.randomUUID(), orderDate, orderItems, PaymentMethod.BNPL, PaymentStatus.PENDING);
            bnplOrder(name, orderDate, orderItems, order);
        }
        return order.getOId();
    }

    private boolean orderItemsExistInInventory(List<Items> orderItems) {
        if (inventory.ifItemInStock(orderItems))
            return true;
        return false;
    }

    private void bnplOrder(String name, String orderDate, List<Items> orderItems, Order order) {
        Double total_price = calculateTotalPrice(orderItems);
        User user = getUser(name);
        if (user.getCreditLimit() - user.getUCredit() >= total_price) {
            CreateBnplOrder.addOrder(order, user);
            CreateBnplOrder.updateUserCredit(user, total_price);
            CreateBnplOrder.reduceInventory(orderItems, inventory);
            System.out.println("Bnpl Order placed:" + order.getOId());
        } else {
            throw new PaymentNotAllowedException("Credit limit exhausted");
        }
    }

    private void prepaidOrder(String name, String orderDate, List<Items> orderItems, Order order) {
        Double total_price = calculateTotalPrice(orderItems);
        User user = userDao.getUser(name);
        CreatePrepaidOrder.addOrder(order, user);
        CreatePrepaidOrder.reduceInventory(orderItems, inventory);
        System.out.println("Prepaid Order placed:" + order.getOId());
    }

    private Double calculateTotalPrice(List<Items> orderItems) {
        Double totalPrice = 0.0;
        for (Items items :
                orderItems) {
            ProductDetail productDetail = inventory.getProductDetail(items.getPName());
            totalPrice = totalPrice + (productDetail.getPPrice() * items.getQuantity());
        }
        return totalPrice;
    }

    private User getUser(String uName) {
        return userDao.getUser(uName);
    }

    public void getUserCreditLeft(String uName) {
        User user = getUser(uName);
        System.out.println("Credit left for "+uName+" is "+(user.getCreditLimit() - user.getUCredit()));
    }

    public void clearDues(String uName, List<UUID> orderList, String dateOfClearing) {
        User user = getUser(uName);
        Double total_price_payable = totalPayablePrice(user,orderList);
        updateOrderStatus(user,orderList);
        CreateBnplOrder.updateUserCredit(user, -total_price_payable);

    }

    private void updateOrderStatus(User user, List<UUID> orderList) {
        for (Order order:
                user.getOrderList()) {
            if(orderList.contains(order.getOId())){
                order.setPaymentStatus(PaymentStatus.COMPLETED);
            }
        }
    }

    private Double totalPayablePrice(User user, List<UUID> orderList) {
        Double total_price_payable = 0.0;
        for (Order order:
                user.getOrderList()) {
            if(orderList.contains(order.getOId())){
                List<Items> orderItems = order.getOrderItems();
                total_price_payable +=  calculateTotalPrice(orderItems);
            }
        }
        return total_price_payable;
    }

    public List<Order> getDues(String uName) {
        User user = getUser(uName);
        List<Order> dueOrderList= new ArrayList<>();
        for (Order order:
             user.getOrderList()) {
            if(order.getPaymentStatus()==PaymentStatus.PENDING || order.getPaymentStatus()==PaymentStatus.DELAYED){
                dueOrderList.add(order);
            }
        }
        return dueOrderList;
    }

    public void viewDues(String uName, String date) {
        User user = getUser(uName);
        List<Order> dueOrder = getDues(uName);
        for (Order order:
        dueOrder) {
            int dateDiff = getDateDiff(order.getOrderDate(),date);
            if(dateDiff > 30){
                order.setPaymentStatus(PaymentStatus.DELAYED);
            }
        }
        if(!(dueOrder==null)){
            Collections.sort(dueOrder, new DateComparator());
        }

        for (Order order:
                dueOrder) {
            System.out.println("OrderId:"+order.getOId()+ "\n totalPayablePrice:"+totalPayablePrice(user,List.of(order.getOId()))+"\n Order detail:"+order.getOrderDate()+","+order.getOrderItems()+" status:"+order.getPaymentStatus());
        }

    }

    public int getDateDiff(String dateString, String currentDateString) {
        String[] dateToken = dateString.split("-");
        String[] currentDateToken = currentDateString.split("-");
        LocalDate date = LocalDate.of(Integer.valueOf(dateToken[0]),Integer.valueOf(dateToken[1]),Integer.valueOf(dateToken[2]));
        LocalDate currentDate = LocalDate.of(Integer.valueOf(currentDateToken[0]),Integer.valueOf(currentDateToken[1]),Integer.valueOf(currentDateToken[2]));
        Period difference = Period.between(date,currentDate);
        int dayDiff = (difference.getYears()*12) +(difference.getMonths()*30)+difference.getDays();
        return dayDiff;
    }


}
