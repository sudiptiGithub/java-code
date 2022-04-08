package com.example.foodorderingsystem.Service;

import com.example.foodorderingsystem.Comparator.RatingComparator;
import com.example.foodorderingsystem.Model.*;
import com.example.foodorderingsystem.Repository.RestrauntDao;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserService {

    private RestrauntDao restrauntDao  = RestrauntDao.getRestrauntDao();
    List<Restraunt> restrauntList = restrauntDao.getRestrauntList();


    public void placeOrder(int order_id, List<OrderEntity> orderEntityList, SelectionStrategy selectionStrategy){
        Orders orders = new Orders(order_id, orderEntityList, OrderStatus.ACCEPTED);
        List<Restraunt> restrauntWithOrderEntityList = getRestrauntWithOrderEntityList(orderEntityList);
        if(selectionStrategy == SelectionStrategy.BEST_RATING){
            if(restrauntWithOrderEntityList!=null && !restrauntWithOrderEntityList.isEmpty()){
                //restrauntWithOrderEntityList.stream().sorted((o1,o2)->(int)(o2.getRating()-o1.getRating())).collect(Collectors.toList());
                Collections.sort(restrauntWithOrderEntityList , new RatingComparator());
                Restraunt restraunt = restrauntWithOrderEntityList.get(0);
                Orders orders1 = new Orders(order_id,orderEntityList,OrderStatus.ACCEPTED);
                restraunt.getOrderList().add(orders1);
                System.out.println("Order:"+order_id+" is generated at:"+restraunt.getRestraunt_name());
            }
        }

        if(selectionStrategy == SelectionStrategy.LOWEST_COST){
            int min = Integer.MAX_VALUE;
            Restraunt restraunt = null;
            if(restrauntWithOrderEntityList!=null && !restrauntWithOrderEntityList.isEmpty()){
                for (Restraunt res:
                restrauntWithOrderEntityList) {
                    int amt =0;
                    for (OrderEntity orderEntity:
                    orderEntityList) {
                        amt += res.getMenu().get(orderEntity.getName());
                    }
                    if(amt<min){
                        min = amt;
                        restraunt = res;
                    }
                }
                Orders orders1 = new Orders(order_id,orderEntityList,OrderStatus.ACCEPTED);
                restraunt.getOrderList().add(orders1);
                System.out.println("Order:"+order_id+" is generated at:"+restraunt.getRestraunt_name());
            }
        }
    }

    public void addRatingToRestraunt(String restraunt_name, int rating){
        List<Restraunt> restraunt = restrauntList.stream().filter(x -> x.getRestraunt_name().equals(restraunt_name)).collect(Collectors.toList());
        if(! restraunt.isEmpty()){
            Restraunt restraunt1 = restraunt.get(0);
            restraunt1.setTotal_no_of_rating((Integer)(restraunt1.getTotal_no_of_rating()+1));
            restraunt1.setRating((Integer)(restraunt1.getRating()+rating)/(restraunt1.getTotal_no_of_rating()));

        }
    }

    private List<Restraunt> getRestrauntWithOrderEntityList(List<OrderEntity> orderEntityList){
        List<String> foodNameList = orderEntityList.stream().map(x -> x.getName()).collect(Collectors.toList());
        return restrauntList.stream().filter(x -> x.getMenu().keySet().containsAll(foodNameList)).filter(y -> y.getOrderList().size()<y.getMax_limit()).collect(Collectors.toList());
    }


}
