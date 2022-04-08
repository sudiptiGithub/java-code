package com.example.foodorderingsystem.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter

public class Restraunt {


    private String restraunt_name;

    private HashMap<String, Integer> menu ;

    private int rating;

    private int max_limit;

    private List<Orders> orderList ;

    private List<Orders> completedOrder;

    private int total_no_of_rating ;

    public Restraunt(String restraunt_name, HashMap<String, Integer> menu, int max_limit, int rating, int total_no_of_rating) {
        this.restraunt_name = restraunt_name;
        this.menu = menu;
        this.max_limit = max_limit;
        this.orderList = new ArrayList<>();
        this.completedOrder = new ArrayList<>();
        this.rating = rating;
        this.total_no_of_rating = total_no_of_rating;
    }
}
