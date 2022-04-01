package com.example.springstart;

public class RegisterPeopleForActivity {

    public void register(AbstractClassDemo abstractClassDemo){
        String name = abstractClassDemo.getName();
        abstractClassDemo.dance(name);
        abstractClassDemo.paint(name);
        abstractClassDemo.play(name);

    }
}
