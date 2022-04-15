package com.example.taskplanner.Model;

public class Subtrack  {

    String title;

    StoryState status;

    public Subtrack(String title) {
        this.title = title;
        this.status = StoryState.OPEN;
    }
}
