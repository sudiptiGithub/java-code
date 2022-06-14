package com.example.taskplanner.Service;

import com.example.taskplanner.Dao.SprintDao;
import com.example.taskplanner.Dao.TaskDao;
import com.example.taskplanner.Model.Task;

import java.util.HashMap;
import java.util.Map;

public class SprintService {

    SprintDao sprintDao = SprintDao.getInstance();

    TaskDao taskDao = TaskDao.getInstance();

    public void createSprint(String sprint_id){
        if(sprintDao.isPresentFalse(sprint_id)){
            sprintDao.addNewSprint(sprint_id);
            System.out.println("New sprint is created:"+sprint_id);
        }
        else {
            System.out.println("Sprint exists");
        }
    }

    public void deleteSprint(String sprint_id){
        if(sprintDao.isPresentFalse(sprint_id)){
            System.out.println("Sprint do not exists");
        }
        else{
            sprintDao.deleteSprint(sprint_id);
        }
    }

    public void addTaskToSprint(String sprint_id,String task_id){
        if(!sprintDao.isPresentFalse(sprint_id) && taskDao.isPresent(task_id)){
            sprintDao.addTaskToSprint(sprint_id,task_id);
        }
    }



    public void removeTaskFromSprint(String sprint_id,String task_id){
        if(!sprintDao.isPresentFalse(sprint_id) && taskDao.isPresent(task_id)){
            sprintDao.removeTaskFromSprint(sprint_id,task_id);
            System.out.println("Removed:"+task_id);
        }
        else{
            System.out.println("Either sprint or task does not exists");
        }
    }

    public void displayTaskOfSprintWithStatus(String sprint_id){
        if(!sprintDao.isPresentFalse(sprint_id)){
            HashMap<String,String> taskHashMap = sprintDao.getAllTask(sprint_id);
            for (Map.Entry entry:
                 taskHashMap.entrySet()) {
                String task_id = (String) entry.getValue();
                Task task = taskDao.getTask(task_id);
                System.out.println("Task id:"+task_id);
                System.out.println("Task status:"+task.getStatus());
            }
        }
    }

}
