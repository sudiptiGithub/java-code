package com.example.taskplanner.Model;

import java.util.UUID;

public class Bug extends Task{

    private Severity severity;

    public Bug(String id, String title, String creator, String assignee, BugState status, TaskType type, String dueDate, Severity severity) {
        super(id, title,creator,assignee,status.toString(),type,dueDate);
        this.severity = severity;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

}
