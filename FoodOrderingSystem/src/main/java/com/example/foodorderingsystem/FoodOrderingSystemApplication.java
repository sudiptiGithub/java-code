package com.example.foodorderingsystem;

import com.example.foodorderingsystem.Model.*;
import com.example.foodorderingsystem.Service.RestrauntService;
import com.example.foodorderingsystem.Service.SystemService;
import com.example.foodorderingsystem.Service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class FoodOrderingSystemApplication {

    public static void main(String[] args) {
        ApplicationContext s = SpringApplication.run(FoodOrderingSystemApplication.class, args);

        RestrauntService restrauntService= s.getBean(RestrauntService.class);

        UserService userService = s.getBean(UserService.class);

        SystemService systemService = s.getBean(SystemService.class);

        systemService.addNewRestraunt("Biryani House",new HashMap<>(){{put("Biryani", 88);put("chick", 85);}},5,0,0);
        systemService.addNewRestraunt("Sonali Biryani House",new HashMap<>(){{put("Biryani", 48);put("chicken", 38);}},5,0,0);
        systemService.addNewRestraunt("New Biryani House",new HashMap<>(){{put("Biryani", 48);put("chicken", 88);}},5,0,0);

        userService.addRatingToRestraunt("New Biryani House",9);
        userService.addRatingToRestraunt("Sonali Biryani House",2);

        userService.placeOrder(1,Arrays.asList(new OrderEntity("Biryani",2),new OrderEntity("chicken",1)),SelectionStrategy.BEST_RATING);
        userService.placeOrder(2,Arrays.asList(new OrderEntity("Biryani",1),new OrderEntity("chicken",1)),SelectionStrategy.LOWEST_COST);

       // restrauntService.completeOrder(1,"New Biryani House");
        //systemService.checkOrdersAtRestraunt("New Biryani House");

    }

}
