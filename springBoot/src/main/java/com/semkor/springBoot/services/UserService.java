package com.semkor.springBoot.services;

import com.semkor.springBoot.models.User;
import jakarta.validation.Valid;

import java.util.List;

public interface UserService {

    public List<User> showAllUsers();

    public User showUser(int id);

    public void deleteUser(int id);

    public void save(User user);

    public void updateUser(User user);
}
