package com.example.taskplanner.Dao;

import com.example.taskplanner.Model.Sprint;
import com.example.taskplanner.Model.Task;

import java.util.HashMap;

public class SprintDao {

    private HashMap<String, Sprint> sprintHashMap = new HashMap<String, Sprint>();

    private SprintDao(){

    }

    private static SprintDao INSTANCE = null;

    public static SprintDao getInstance(){
        if(INSTANCE==null){
            INSTANCE = new SprintDao();
        }
        return INSTANCE;
    }


    public boolean isPresentFalse(String sprint_id) {
        if(sprintHashMap.containsKey(sprint_id)) return false;
        return true;
    }

    public void addNewSprint(String sprint_id) {
        sprintHashMap.put(sprint_id,new Sprint(sprint_id));
    }

    public void deleteSprint(String sprint_id) {
        sprintHashMap.remove(sprint_id);
    }

    public void addTaskToSprint(String sprint_id, String task) {
        sprintHashMap.get(sprint_id).getTaskHashMap().put(sprint_id,task);
    }

    public void removeTaskFromSprint(String sprint_id, String task_id) {
        sprintHashMap.get(sprint_id).getTaskHashMap().remove(sprint_id);
    }

    public HashMap<String, String> getAllTask(String sprint_id) {
        return sprintHashMap.get(sprint_id).getTaskHashMap();
    }
}
