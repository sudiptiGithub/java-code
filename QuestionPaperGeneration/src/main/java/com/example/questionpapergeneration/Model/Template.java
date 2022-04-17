package com.example.questionpapergeneration.Model;

import java.util.HashMap;

public class Template<T> {

    private int totalMarks;

    private FilterCriteria filterCriteria;

    private HashMap<T , Integer> distributionRatio;

    public Template(int totalMarks, FilterCriteria filterCriteria, HashMap<T, Integer> distributionRatio) {
        this.totalMarks = totalMarks;
        this.filterCriteria = filterCriteria;
        this.distributionRatio = distributionRatio;
    }
}
