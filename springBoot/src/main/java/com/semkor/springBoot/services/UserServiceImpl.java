package com.semkor.springBoot.services;

import com.semkor.springBoot.models.User;
import com.semkor.springBoot.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly=true)
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //возвращаем всех полльзователей
    @Override
    public List<User> showAllUsers() {
        return userRepository.findAll();
    }

    //возвращаем пользователя по id
    @Override
    public User showUser(int id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new EntityNotFoundException("User not found for ID: " + id);
        }
        return user.get();
    }



    //сохранить пользователя
    @Transactional
    @Override
    public void save(User user) {userRepository.save(user);}

    // радктировать пользователя
    @Transactional
    @Override
    public void updateUser(User user) {
        Optional<User> updatedUser = userRepository.findById(user.getId());
        if (updatedUser.isPresent()) {
            User updateUser = updatedUser.get();
            updateUser.setName(user.getName());
            updateUser.setSurname(user.getSurname());
            updateUser.setAge(user.getAge());
            userRepository.save(updateUser);
        }

    }

    // удалить пользователя
    @Transactional
    @Override
    public void deleteUser(int id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new EntityNotFoundException("User not found for ID: " + id);
        }

        userRepository.delete(user.get());
    }
}
