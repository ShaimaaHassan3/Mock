package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServices {
    UserRepo userRepo;

    ArrayList<User> users = new ArrayList<>();

    public UserServices(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserServices(ArrayList<User> users) {
        this.users = users;
    }

    public List<User> getAllUser() {
        List<User> users = new ArrayList();
        userRepo.findAll().forEach(users::add);
        return users;
    }

    public Long getNumberOfUser() {
        return userRepo.count();
    }

    public String getById(int id) {
        return userRepo.findById(id).getName();
    }

    public User add(User user) {
        users.add(user);
        return userRepo.save(user);
    }
}
