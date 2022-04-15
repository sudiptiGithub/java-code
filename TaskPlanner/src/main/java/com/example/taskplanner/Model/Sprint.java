package com.example.taskplanner.Model;

import java.util.HashMap;

public class Sprint {

    String sprint_name;

    HashMap<String, String> taskHashMap;

    public Sprint(String sprint_name) {
        this.sprint_name = sprint_name;
        this.taskHashMap = new HashMap<>();
    }

    public String getSprint_name() {
        return sprint_name;
    }

    public HashMap<String, String> getTaskHashMap() {
        return taskHashMap;
    }
}
