package com.example.questionpapergeneration.Service;

import com.example.questionpapergeneration.DataBase.QuestionDao;
import com.example.questionpapergeneration.Model.Question;
import com.example.questionpapergeneration.Model.FilterCriteria;

import java.util.HashMap;
import java.util.List;

public class QuestionPaperServive {

    QuestionDao questionDao = QuestionDao.getInstance();

    public void basedOnFilterCriteria(Integer marks, FilterCriteria topic, HashMap<String,Integer> template_ratio){
        if(topic.equals(FilterCriteria.DIFFICULTY)){
            List<Question> questionPapers =  questionDao.getQuestionsOnDifficulty(template_ratio);
            for (Question question:
                    questionPapers) {
                System.out.println("UID:"+question.getQuestionId()+" "+"Text:"+question.getText()+" "+"Topic:"+question.getTopic()+" "+"Subject:"+question.getSubject()+" "+"DifficultyLevel:"+question.getDifficultyLevel()+" "+"Marks:"+question.getMarks());
            }
        }
    }
}
