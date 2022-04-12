package com.example.questionpapergeneration.Service;

import com.example.questionpapergeneration.DataBase.QuestionDao;
import com.example.questionpapergeneration.Model.Question;
import com.example.questionpapergeneration.Model.TEMPLATE_TOPIC;

import java.util.HashMap;
import java.util.List;

public class QuestionPaperServive {

    QuestionDao questionDao = QuestionDao.getInstance();

    public void basedOnTopic(Integer marks, TEMPLATE_TOPIC topic, HashMap<String,Integer> template_ratio){
        if(topic == TEMPLATE_TOPIC.DIFFICULTY){
            List<Question> questionPapers =  questionDao.getQuestionOnDifficulty(template_ratio);
            for (Question question:
                    questionPapers) {
                System.out.println("UID:"+question.getUid()+" "+"Text:"+question.getText()+" "+"Topic:"+question.getTopic()+" "+"Subject:"+question.getSubject()+" "+"DifficultyLevel:"+question.getDifficultyLevel()+" "+"Marks:"+question.getMarks());
            }
        }
    }
}
