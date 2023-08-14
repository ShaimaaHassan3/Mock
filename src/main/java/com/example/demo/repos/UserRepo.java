package com.example.demo.repos;

import com.example.demo.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface UserRepo extends CrudRepository<User, Integer>, QueryByExampleExecutor<User> {
    User findById(int id);
}
