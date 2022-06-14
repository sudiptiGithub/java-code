package com.company.Model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
public class User {

    private String name;

    private HashMap<String,List<Song>> playlistHashMap;

    public User(String name) {
        this.name = name;
        this.playlistHashMap = new HashMap<String ,List<Song>>();
    }

}
