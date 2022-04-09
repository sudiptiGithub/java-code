package Repo;

import Exceptions.UserDoesNotExistsException;
import Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDao {

    private HashMap<String, User> userList = new HashMap<>();

    private static UserDao INSTANCE = null;

    public static UserDao getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new UserDao();
        }
        return INSTANCE;
    }

    public void addUser(User user){
        userList.put(user.getUName(),user);
        System.out.println("User added:"+user.getUName()+" with credit limit:"+user.getCreditLimit());
    }

    public User getUser(String uname){
        if(userList.containsKey(uname)){
            return userList.get(uname);
        }
        else {
            throw new UserDoesNotExistsException("User "+ uname+" does not exists");
        }
    }
}
