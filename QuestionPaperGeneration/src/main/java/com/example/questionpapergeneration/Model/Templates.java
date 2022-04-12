package com.example.questionpapergeneration.Model;

import java.util.HashMap;

public class Templates<T> {

    private int total_marks;

    private TEMPLATE_TOPIC template_topic;

    private HashMap<T , Integer> template_ratio;

    public Templates(int total_marks, TEMPLATE_TOPIC template_topic, HashMap<T, Integer> template_ratio) {
        this.total_marks = total_marks;
        this.template_topic = template_topic;
        this.template_ratio = template_ratio;
    }
}
