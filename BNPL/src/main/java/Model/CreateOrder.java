package Model;

import Repo.Inventory;
import Repo.UserDao;

import java.util.List;

public class CreateOrder {

    public static void addOrder(Order order, User user){
        user.getOrderList().add(order);
    }

    public static void reduceInventory(List<Items> orderItems, Inventory inventory) {
        for (Items items :
                orderItems) {
            ProductDetail productDetail = inventory.getProductDetail(items.getPName());
            productDetail.setPQuantity(productDetail.getPQuantity() - items.getQuantity());
        }
    }

}
