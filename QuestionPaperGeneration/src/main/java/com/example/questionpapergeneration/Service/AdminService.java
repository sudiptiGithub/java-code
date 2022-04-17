package com.example.questionpapergeneration.Service;

import com.example.questionpapergeneration.DataBase.QuestionDao;
import com.example.questionpapergeneration.Model.Difficulty;
import com.example.questionpapergeneration.Model.Question;
import com.example.questionpapergeneration.Model.Subject;

import java.util.UUID;

public class AdminService {

    QuestionDao questionDao = QuestionDao.getInstance();

    public void addQuestionToQuestionBank(String text, Subject subject, String topic, Difficulty difficulty_level, int marrks){
        UUID uid = UUID.randomUUID();
        Question questionPaper = new Question(uid, text, subject,topic,difficulty_level,marrks);
        questionDao.addQuestion(questionPaper);
    }


}
