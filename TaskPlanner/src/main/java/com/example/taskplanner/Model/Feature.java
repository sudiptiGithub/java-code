package com.example.taskplanner.Model;

import java.util.UUID;

public class Feature extends Task {

    private String feature_summary;

    private Impact impact;

    public Feature(String id, String title, String creator, String assignee, String status, TaskType type, String dueDate) {
        super(id, title, creator, assignee, status, type, dueDate);
    }
}
