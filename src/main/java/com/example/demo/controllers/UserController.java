package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserServices userServices;

    @GetMapping("/users")
    public List<User> getAllCustomer() {
        return userServices.getAllUser();
    }
    @GetMapping("/users/count")
    public long getNumberOfUsers() {
        return userServices.getNumberOfUser();
    }
    @GetMapping("/users/{id}")
    public String getCustomerById(@PathVariable("id") int id) {
        return userServices.getById(id);
    }
}
