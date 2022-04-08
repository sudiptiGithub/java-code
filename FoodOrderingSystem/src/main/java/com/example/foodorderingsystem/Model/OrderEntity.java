package com.example.foodorderingsystem.Model;

import lombok.Getter;
import lombok.Setter;

public class OrderEntity {

    @Getter
    private String name;

    @Setter
    private int quantity;

    public OrderEntity(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

}
