package com.example.foodorderingsystem.Model;

import java.util.List;

public class Orders {

    private int order_id;

    private List<OrderEntity> food_list;

    private OrderStatus orderStatus;

    public Orders(int order_id, List<OrderEntity> food_list, OrderStatus orderStatus) {
        this.order_id = order_id;
        this.food_list = food_list;
        this.orderStatus = orderStatus;
    }


    public int getOrder_id() {
        return order_id;
    }

    public List<OrderEntity> getFood_list() {
        return food_list;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
