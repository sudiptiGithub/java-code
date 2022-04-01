package com.example.springstart.extra;

import org.springframework.stereotype.Component;

@Component
public class Emp {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object o){
        if(o == null || o.getClass() != getClass())
            return false;
        if(o == this)
            return true;
        Emp e =  (Emp)o;
        return e.getId()==getId();
    }

    public int hashcode(){
        return getId();
    }
}
