package com.example.springstart;

public class DemoClassMona extends AbstractClassDemo{
    @Override
    public String getName() {
        System.out.println("My name is Mona");
        return "Mona";
    }

    @Override
    public void play(String name) {
        System.out.println(name+" likes to play");
    }

    @Override
    public void paint(String name) {
        System.out.println(name+" likes to paint");
    }

    @Override
    public void dance(String name){
        System.out.println(name+" likes to dance");
    }
}
