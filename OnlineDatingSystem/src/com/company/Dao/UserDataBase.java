package com.company.Dao;

import com.company.Exceptions.UserAlreadyExistsException;
import com.company.Model.User;
import com.company.Service.SystemService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDataBase implements UserDataInterface{

    HashMap<String,User> userMap = new HashMap<>();

    private static final UserDataBase INSTANCE =new UserDataBase();

    public static  UserDataBase getInstance(){
        return INSTANCE;
    }

    @Override
    public void add_user(User user) {
        if(userMap.get(user)!=null){
            throw new UserAlreadyExistsException("Username already exists");
        }
        else{
            userMap.put(user.getName(),user);
            System.out.println("User Added:"+user.getName());
        }
    }

    @Override
    public User get_User(String user) {
        return userMap.get(user);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }
}
