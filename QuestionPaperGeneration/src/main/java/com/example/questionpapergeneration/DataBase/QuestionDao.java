package com.example.questionpapergeneration.DataBase;

import com.example.questionpapergeneration.Exceptions.BookIdAlreadyExistsExcepion;
import com.example.questionpapergeneration.Model.Difficulty;
import com.example.questionpapergeneration.Model.Question;

import java.util.*;
import java.util.stream.IntStream;

//singleton class
public class QuestionDao {

    private HashMap<UUID, Question> questionBank = new HashMap<UUID, Question>();

    private static QuestionDao INSTANCE = null;

    public static QuestionDao getInstance(){
        if(INSTANCE == null){
            INSTANCE = new QuestionDao();
        }
        return INSTANCE;
    }

    public void addQuestion(Question questionPaper) {
        if(questionBank.containsKey(questionPaper.getUid())){
            throw new BookIdAlreadyExistsExcepion("Book Id Already Exists. Try Adding again");
        }
        questionBank.put(questionPaper.getUid(),questionPaper);
        System.out.println(questionPaper.getUid()+" added to qusetionBank");
    }

    public List<Question> getQuestionOnDifficulty(HashMap<String, Integer> template_ratio) {

        List<Question> questions = new ArrayList<>();
        //Assuming easy questions are of 2 marks, medium of 5 marks, hard of 10 marks
        for (Map.Entry mapEntry:
        template_ratio.entrySet()) {
            if(mapEntry.getKey()== "EASY")
            {
                List<Question> easyQuestionList = getQuestions(Difficulty.EASY);
                int no_of_questions = (int)mapEntry.getValue()/2;
                questions.addAll(getRandomElement(easyQuestionList,no_of_questions));
            }
            else if(mapEntry.getKey()== "MEDIUM"){
                List<Question> mediumQuestionList = getQuestions(Difficulty.MEDIUM);
                int no_of_questions = (int)mapEntry.getValue()/5;
                questions.addAll(getRandomElement(mediumQuestionList,no_of_questions));
            }
            else if(mapEntry.getKey()== "HARD"){
                List<Question> hardQuestionList = getQuestions(Difficulty.HARD);
                int no_of_questions = (int)mapEntry.getValue()/10;
                questions.addAll(getRandomElement(hardQuestionList,no_of_questions));
            }
        }
        return questions;
        
    }

    private List<Question> getQuestions(Difficulty difficulty) {

        List<Question> questionList = new ArrayList<>();
        for (Map.Entry mapEntry:
             questionBank.entrySet()) {
            Question question = (Question) mapEntry.getValue();
            if(question.getDifficultyLevel()== difficulty)
                questionList.add(question);
        }
        return questionList;
    }

    private List<Question> getRandomElement(List<Question> list, int totalItems)
    {
        Random rand = new Random();

        // create a temporary list for storing
        // selected element
        List<Question> newList = new ArrayList<>();
        for (int i = 0; i < totalItems; i++) {

            if(list.size()==0)
                break;
            // take a random index between 0 to size
            // of given List
            int randomIndex = rand.nextInt(list.size());

            // add element in temporary list
            newList.add(list.get(randomIndex));
            list.remove(list.get(randomIndex));
        }
        return newList;
    }
}
