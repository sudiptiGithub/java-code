package com.example.taskplanner.Model;

import javax.naming.ldap.HasControls;
import java.util.HashMap;
import java.util.UUID;

public class Story extends Task{

    private String story_summary;

    private HashMap<String, Subtrack> subtrackHashMap;

    public Story(String id, String title, String creator, String assignee, StoryState status, TaskType type, String dueDate, String story_summary ) {
        super(id, title, creator, assignee, status.toString(), type, dueDate);
        this.story_summary = story_summary;
        this.subtrackHashMap = new HashMap<>();
    }

    public void addSubtrack(Subtrack subtrack) {
        subtrackHashMap.put(subtrack.title,subtrack);
    }

    public String getStory_summary() {
        return story_summary;
    }

    public HashMap<String, Subtrack> getSubtrackHashMap() {
        return subtrackHashMap;
    }
}
