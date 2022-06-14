package com.example.taskplanner.Model;

import java.util.UUID;

public class Task {

    private String id;

    private String title;

    private String creator;

    private String assignee;

    private String status;

    private TaskType type;

    private String dueDate;

    public Task(String id, String title, String creator, String assignee, String status, TaskType type, String dueDate) {
        this.id = id;
        this.title = title;
        this.creator = creator;
        this.assignee = assignee;
        this.status = status;
        this.type = type;
        this.dueDate = dueDate;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCreator() {
        return creator;
    }

    public String getAssignee() {
        return assignee;
    }

    public String getStatus() {
        return status;
    }

    public TaskType getType() {
        return type;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
        System.out.println("Assignee updated");
    }

    public void setStatus(String status) {
        this.status = status;
        System.out.println("Status updated");
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
