package com.example.springstart;

public abstract class AbstractClassDemo implements InterfaceDemo{

    public abstract String getName();

    public void dance(String name){
        System.out.println(name + " do not likes dance");
    }

}
