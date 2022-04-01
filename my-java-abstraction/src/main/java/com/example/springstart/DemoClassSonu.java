package com.example.springstart;

public class DemoClassSonu extends AbstractClassDemo{
    @Override
    public String getName() {
        System.out.println("My name is Sonu");
        return "Sonu";
    }

    @Override
    public void play(String name) {
        System.out.println(name+" likes to play");
    }

    @Override
    public void paint(String name) {
        System.out.println(name+" do not likes to paint");
    }

}
