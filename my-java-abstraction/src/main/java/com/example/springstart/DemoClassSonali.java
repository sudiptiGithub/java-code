package com.example.springstart;

public class DemoClassSonali extends AbstractClassDemo {
    @Override
    public String getName() {
        System.out.println("My name is Sonali");
        return "Sonali";
    }

    @Override
    public void play(String name) {
        System.out.println(name+" likes to play");
    }

    @Override
    public void paint(String name) {
        System.out.println(name+" likes to paint");
    }

}
