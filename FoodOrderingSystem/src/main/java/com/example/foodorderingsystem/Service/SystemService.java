package com.example.foodorderingsystem.Service;

import com.example.foodorderingsystem.Model.Orders;
import com.example.foodorderingsystem.Model.Restraunt;
import com.example.foodorderingsystem.Repository.RestrauntDao;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SystemService {

    RestrauntDao restrauntDao  = RestrauntDao.getRestrauntDao();
    List<Restraunt> restrauntList = restrauntDao.getRestrauntList();

    public void addNewRestraunt(String restraunt_name, HashMap<String,Integer> menu, int max_limit, int rating, int total_no_of_rating) {

        Restraunt restraunt = new Restraunt(restraunt_name, menu, max_limit,rating,total_no_of_rating);
        restrauntList.add(restraunt);
        System.out.println("Restrant :"+restraunt_name+" added");

    }

    public void checkOrdersAtRestraunt(String restrauntName){
        Restraunt restraunt1 = restrauntList.stream().filter( restraunt -> restraunt.getRestraunt_name().equals(restrauntName)).collect(Collectors.toList()).get(0);
        if(restraunt1.getOrderList().isEmpty()){
            System.out.println("No orders currently");
        }
        else{
            for (Orders orders:
                    restraunt1.getOrderList()) {
                System.out.println(orders.getOrder_id());
            }
        }
    }

}
