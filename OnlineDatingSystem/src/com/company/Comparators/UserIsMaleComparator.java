package com.company.Comparators;

import com.company.Model.User;

import java.util.Comparator;

public class UserIsMaleComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o2.getGender().compareTo(o1.getGender());
    }
}
