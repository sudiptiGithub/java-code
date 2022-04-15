package com.example.taskplanner.Dao;

import com.example.taskplanner.Model.Story;
import com.example.taskplanner.Model.Subtrack;
import com.example.taskplanner.Model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskDao {

    private HashMap<String, Task> taskMap = new HashMap<>();

    private TaskDao(){

    }

    private static TaskDao INSTANCE = null;

    public static TaskDao getInstance(){
        if(INSTANCE==null){
            INSTANCE = new TaskDao();
        }
        return INSTANCE;
    }

    public HashMap<String, Task> getTaskMap() {
        return taskMap;
    }

    public boolean isPresent(String story) {
        if(taskMap.containsKey(story)) return true;
        return false;
    }

    public void putSubtrackInStory(String story, Subtrack subtrack) {
        Story storyTask = (Story) taskMap.get(story);
        if(storyTask.getStatus().equals("COMPLETED"))
            System.out.println("Story is complketed, cannot assign subtrack to it");
        else
            storyTask.addSubtrack(subtrack);
    }

    public void addTask(String id, Task task) {
        taskMap.put(id,task);
    }


    public void updateTaskStatus(String task_id, String status) {
        taskMap.get(task_id).setStatus(status);
    }

    public void updateAssignee(String task_id, String assignee) {
        taskMap.get(task_id).setAssignee(assignee);
    }

    public Task getTask(String task_id) {
        return taskMap.get(task_id);
    }

    public List<Task> getTaskByUser(String user) {
        List<Task> taskList = new ArrayList<>();
        for (Map.Entry taskEntry:
             taskMap.entrySet()) {
            Task task = (Task)taskEntry.getValue();
            if(task.getAssignee().equals(user))
                taskList.add(task);
        }
        return taskList;
    }
}
