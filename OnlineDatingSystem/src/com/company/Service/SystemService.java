package com.company.Service;

import com.company.Comparators.UserIsFemaleComparator;
import com.company.Comparators.UserIsMaleComparator;
import com.company.Dao.UserDataBase;
import com.company.Dao.UserLikesDB;
import com.company.Model.Gender;
import com.company.Model.User;

import java.util.*;

public class SystemService {

    UserDataBase userDataBase = UserDataBase.getInstance();

    UserLikesDB userLikesDB = UserLikesDB.getInstance();

    public void add_user(String name, String location, String interest, Gender gender, int age) {
        User user = new User(name,location,interest,gender,age);
        userDataBase.add_user(user);
    }

    public void getMatches(String name){
        User user = userDataBase.get_User(name);
        List<User> userList = userDataBase.getAllUsers();
        if(userList.contains(user)){
            userList.remove(user);
        }
        List<String> interest = Arrays.stream(user.getInterests().split(",")).toList();
        sortByGender(userList,user);
        //sortByInterest(userList,user.getInterests());
        for (User user1:
             userList) {
            System.out.println(user1.getName()+" "+user1.getGender());

        }

    }

    private void sortByMaxCommonInterest(List<User> userList, String interests) {
        List<String> interest = Arrays.stream(interests.split(",")).toList();
        HashMap<User,Integer> userSimilarInterest = new HashMap<>();
        for (User user:
                userList) {
            int count = getCommonInterestCount(user.getInterests(),interest);
            userSimilarInterest.put(user,count);
        }
    }

    private int getCommonInterestCount(String interests, List<String> interest) {
        int count =0;
        for (String interest1:interest
             ) {
            if(interests.contains(interest1)){
                count++;
            }
        }
        return count;
    }

    private void sortByGender(List<User> userList, User user) {
        if(user.getGender().equals(Gender.MALE)){
            Collections.sort(userList, new UserIsMaleComparator());
        }
        else{
            Collections.sort(userList, new UserIsFemaleComparator());
        }
    }


    public void userLike(String a,  String b){
        userLikesDB.addLike(a,b);
    }

    public void does_user_like(String a,  String b){
        if(userLikesDB.doesUserLike(a,b) && userLikesDB.doesUserLike(b,a)){
            System.out.println(a+" and "+b+" likes each other");
        }
    }

    public void matches() {
        for (String st:
        userLikesDB.matches() ) {
            String[] s = st.split(",");
            System.out.println(s[0]+" and "+s[1]+ " likes each other");
        }
    }
}
