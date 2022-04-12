package com.example.questionpapergeneration;

import com.example.questionpapergeneration.Model.Difficulty;
import com.example.questionpapergeneration.Model.Subject;
import com.example.questionpapergeneration.Model.TEMPLATE_TOPIC;
import com.example.questionpapergeneration.Service.AdminService;
import com.example.questionpapergeneration.Service.QuestionPaperServive;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class QuestionPaperGenerationApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionPaperGenerationApplication.class, args);

        AdminService adminService = new AdminService();
        QuestionPaperServive questionPaperServive = new QuestionPaperServive();

        adminService.addQuestionToQuestionBank("What is your name", Subject.ENGLISH,"INTRO", Difficulty.EASY,2);
        adminService.addQuestionToQuestionBank("2+2", Subject.MATH,"INTRO", Difficulty.EASY,2);
        adminService.addQuestionToQuestionBank("What is CAPITAL OF India", Subject.SCIENCE,"INTRO", Difficulty.EASY,2);
        adminService.addQuestionToQuestionBank("What is your aim", Subject.ENGLISH,"INTRO", Difficulty.EASY,2);
        adminService.addQuestionToQuestionBank("5/6", Subject.MATH,"INTRO", Difficulty.EASY,2);

        adminService.addQuestionToQuestionBank("What is diameter of earth", Subject.SST,"SolarSystem", Difficulty.MEDIUM,20);

        questionPaperServive.basedOnTopic(10, TEMPLATE_TOPIC.DIFFICULTY,new HashMap<String,Integer>(){{put("EASY",4);}});

      //  questionPaperServive.basedOnTopic(10, TEMPLATE_TOPIC.TOPIC,new HashMap<String,Integer>(){{put("OS",4);put("DS",6);}});


    }

}
