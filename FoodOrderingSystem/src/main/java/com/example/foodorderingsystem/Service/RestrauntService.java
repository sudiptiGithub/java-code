package com.example.foodorderingsystem.Service;

import com.example.foodorderingsystem.Comparator.RatingComparator;
import com.example.foodorderingsystem.Model.*;
import com.example.foodorderingsystem.Repository.RestrauntDao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestrauntService {

    private RestrauntDao restrauntDao  = RestrauntDao.getRestrauntDao();
    private List<Restraunt> restrauntList = restrauntDao.getRestrauntList();

    public void completeOrder(int order_id, String restrauntName){
        Restraunt res = restrauntList.stream().filter(r -> r.getRestraunt_name().equals(restrauntName)).collect(Collectors.toList()).get(0);
        if(res!=null){
            Orders orders = (Orders) res.getOrderList().stream().filter(o -> o.getOrder_id()==order_id).collect(Collectors.toList()).get(0);
            orders.setOrderStatus(OrderStatus.COMPLETED);
            res.getCompletedOrder().add(orders);
            res.getOrderList().remove(orders);
            System.out.println("Order:"+order_id+" at restraunt:"+restrauntName+" is Completed");
        }
    }



}
