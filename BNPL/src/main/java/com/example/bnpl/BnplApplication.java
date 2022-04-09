package com.example.bnpl;

import Model.Items;
import Model.PaymentMethod;
import Service.SystemService;
import Service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class BnplApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BnplApplication.class, args);

        SystemService systemService = new SystemService();

        UserService userService = new UserService();

        systemService.addProductToRepo("Bat",3,78.0);
        systemService.addProductToRepo("Ball",10,18.0);

        systemService.getInventory();

        systemService.addUder("Sonali");

        UUID orderId1 = userService.buy("Sonali","2022-04-09",new ArrayList<>(List.of(new Items("Bat",1),new Items("Ball" ,
                2))), PaymentMethod.BNPL);
        UUID orderId2 = userService.buy("Sonali","2022-05-09",new ArrayList<>(List.of(new Items("Bat",1),new Items("Ball" ,
                2))), PaymentMethod.BNPL);
        UUID orderId3 = userService.buy("Sonali","2022-05-03",new ArrayList<>(List.of(new Items("Bat",1),new Items("Ball" ,
                2))), PaymentMethod.PREPAID);

        userService.getUserCreditLeft("Sonali");

        userService.clearDues("Sonali", List.of(orderId1), "2202-04-22");

      //  userService.getUserCreditLeft("Sonali");

        userService.viewDues("Sonali","2022-05-22");

    }

}
