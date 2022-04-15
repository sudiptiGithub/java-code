package com.example.taskplanner.Service;

import com.example.taskplanner.Dao.TaskDao;
import com.example.taskplanner.Model.*;

import java.util.List;

public class TaskService {


    TaskDao taskDao = TaskDao.getInstance();

    public void createTask(String id,String title, String creator, String assignee, TaskType type, String dueDate, String... taskInf){
        if(type==TaskType.BUG){
            Task task = new Bug(id,title,creator,assignee, BugState.OPEN,TaskType.BUG,dueDate, Severity.valueOf(taskInf[0]));
            taskDao.addTask(task.getId(),task);
            System.out.println("Bug is generated:"+task.getId());
        }
            else if(type==TaskType.STORY){
            Task task = new Story(id,title,creator,assignee, StoryState.OPEN,TaskType.STORY,dueDate, taskInf[0]);
            taskDao.addTask(task.getId(),task);
            System.out.println("Story is generated:"+task.getId());
        }
    }

    public void createSubtrack(String title, String story){
        if(taskDao.isPresent(story)){
            Subtrack subtrack = new Subtrack(title);
            taskDao.putSubtrackInStory(story,subtrack);
            System.out.println("Subtrack created");
        }
        else {
            System.out.println("Story does not exists");
        }
    }

    public void changeStatusOfTaskOrSubtrack(String task_id, String status){
        if(taskDao.isPresent(task_id)){
            taskDao.getTask(task_id).setStatus(status);}
        else {
            System.out.println("Task does not exists");
        }
    }

    public void changeAssigneOfTask(String task_id, String assignee){
        if(taskDao.isPresent(task_id)){
            taskDao.getTask(task_id).setAssignee(assignee);
        }
        else {
            System.out.println("Task does not exists");
        }
    }

    public void getAssigneOfTask(String task_id) {
        if(taskDao.isPresent(task_id)){
            System.out.println(taskDao.getTask(task_id).getAssignee());
        }
    }

    public void displayTaskAssignedToUserByTaskType(String user){
        List<Task> taskList = taskDao.getTaskByUser(user);
        for (Task task:
             taskList) {
            System.out.println(task.getTitle());
            System.out.println(task.getType());
        }
    }
}
