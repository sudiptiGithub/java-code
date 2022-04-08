package com.example.foodorderingsystem.Comparator;

import com.example.foodorderingsystem.Model.Restraunt;

import java.util.Comparator;
import java.util.List;

public class RatingComparator implements Comparator<Restraunt> {

    @Override
    public int compare(Restraunt o1, Restraunt o2) {
        return o2.getRating()-o1.getRating();
    }
}
