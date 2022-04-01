package com.example.springstart.extra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Apple {

    @Autowired
    Mango mango;

    @Autowired
    Fruit fruit;


    public void printName(){
        System.out.println("Apple Printed");
        mango.printName1();
        fruit.setName("banana");
        System.out.println(fruit.getName());
    }
}
