package com.example.taskplanner;

import com.example.taskplanner.Model.StoryState;
import com.example.taskplanner.Model.TaskType;
import com.example.taskplanner.Service.SprintService;
import com.example.taskplanner.Service.TaskService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskPlannerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskPlannerApplication.class, args);


        TaskService taskService = new TaskService();

        SprintService sprintService = new SprintService();

        taskService.createTask("BUG-1","FirstBug","Sudipti","Sudipti", TaskType.BUG,"2022-08-23","PO");

        taskService.createTask("STORY-1","FirstStory","Sudipti","Sudipti", TaskType.STORY,"2022-08-23","new description");

        taskService.createSubtrack("Play","STORY-1");

        taskService.changeStatusOfTaskOrSubtrack("STORY-1", StoryState.INPROGRESS.toString());

//        taskService.changeAssigneOfTask("STORY-1","Mona");
//        taskService.getAssigneOfTask("STORY-1");

        taskService.displayTaskAssignedToUserByTaskType("Sudipti");

        sprintService.createSprint("SPRINT-1");
        sprintService.addTaskToSprint("SPRINT-1","STORY-1");
        sprintService.addTaskToSprint("SPRINT-1","BUG-1");
        sprintService.displayTaskOfSprintWithStatus("SPRINT-1");
        sprintService.removeTaskFromSprint("SPRINT-1","BUG-1");
        sprintService.displayTaskOfSprintWithStatus("SPRINT-1");
        sprintService.deleteSprint("SPRINT-1");
        sprintService.removeTaskFromSprint("SPRINT-1","BUG-1");

    }

}
