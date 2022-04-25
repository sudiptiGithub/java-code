package com.company.Dao;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

public class UserLikesDB {

    HashMap<String, List<String>> userlike = new HashMap<String, List<String>>();

    private static final UserLikesDB INSTANCE = new UserLikesDB();

    public static UserLikesDB getInstance() {
        return INSTANCE;
    }

    public void addLike(String user1, String user2) {
        if (userlike.containsKey(user1)) {
            if (!userlike.get(user1).contains(user2)) {
                userlike.get(user1).add(user2);
                System.out.println(user1 + " likes " + user2);
            }
        } else {
            userlike.put(user1, new ArrayList<String>(Arrays.asList(user2)));
            System.out.println(user1 + " likes " + user2);
        }
    }

    public boolean doesUserLike(String user1, String user2) {
        if (userlike.get(user1) != null) {
            if (userlike.get(user1).contains(user2))
                return true;
        }
        return false;
    }

    public List<String> matches() {
        List<String> match = new ArrayList<>();
        for (Map.Entry entry :
                userlike.entrySet()) {
            String user1 = (String) entry.getKey();
            List<String> liked = (List<String>) entry.getValue();
            for (String user2 :
                    liked) {
                if (userlike.get(user2).contains(user1)) {
                    match.add(user1 +","+ user2);
                }

            }
        }
        return match;
    }
}



