package com.company.Dao;

import com.company.Model.User;

import java.util.List;

public interface UserDataInterface {

    public void add_user(User user);

    public User get_User(String user);

    public List<User> getAllUsers();

}
