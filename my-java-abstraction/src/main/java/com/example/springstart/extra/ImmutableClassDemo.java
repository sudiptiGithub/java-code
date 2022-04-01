package com.example.springstart.extra;

// make clss final so that it cannot be inherited
public final class ImmutableClassDemo {

    private final int id;

    private final String name;

    public ImmutableClassDemo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
