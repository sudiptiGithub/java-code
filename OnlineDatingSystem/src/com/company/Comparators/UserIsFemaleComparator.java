package com.company.Comparators;

import com.company.Model.User;

import java.util.Comparator;

public class UserIsFemaleComparator  implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getGender().compareTo(o2.getGender());
    }
}
