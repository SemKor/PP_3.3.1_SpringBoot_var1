package com.semkor.springBoot.services;

import com.semkor.springBoot.models.User;

import java.util.List;

public interface UserService {

    public List<User> showAllUsers();

    public void saveOrUpdateUser(User user);

    public User showUser(int id);

    public void deleteUser(int id);
}
