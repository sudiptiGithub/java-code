package com.company.Model;

import lombok.*;

@Getter
@Setter
public class User {

    @Setter(AccessLevel.NONE)
    private String name;

    private String location;

    private String interests;

    private Gender gender;

    private int age;

    public User(String name, String location, String interests, Gender gender, int age) {
        this.name = name;
        this.location = location;
        this.interests = interests;
        this.gender = gender;
        this.age = age;
    }

}
