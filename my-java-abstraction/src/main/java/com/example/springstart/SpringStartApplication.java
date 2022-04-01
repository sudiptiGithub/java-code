package com.example.springstart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringStartApplication {

    public static void main(String[] args) {
        ApplicationContext aa = SpringApplication.run(SpringStartApplication.class, args);
//        System.out.println("Application name is: -------");
//        System.out.println(aa.getDisplayName());
//        System.out.println(aa.getId());

//        Apple apple = aa.getBean(Apple.class);
//        Fruit fruit = aa.getBean(Fruit.class);
//
//
//        apple.printName();
//        fruit.setName("grapes");
//        System.out.println(fruit.getName());


//        ImmutableClassDemo immutableClassDemo = new ImmutableClassDemo(1,"sona");
//        immutableClassDemo.getId();
//

        RegisterPeopleForActivity registerPeopleForActivity = new RegisterPeopleForActivity();

        AbstractClassDemo abstractClassDemo= new DemoClassSonali();
        registerPeopleForActivity.register(abstractClassDemo);

        AbstractClassDemo abstractClassDemo1= new DemoClassMona();
        registerPeopleForActivity.register(abstractClassDemo1);

    }


}
