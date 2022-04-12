package com.example.questionpapergeneration.Model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Question {

    private UUID uid;
    private String text;
    private Subject subject;
    private String topic;
    private Difficulty difficultyLevel;
    private int marks;

    public Question(UUID uid, String text, Subject subject, String topic, Difficulty difficultyLevel, int marks) {
        this.uid = uid;
        this.text = text;
        this.subject = subject;
        this.topic = topic;
        this.difficultyLevel = difficultyLevel;
        this.marks = marks;
    }
}
