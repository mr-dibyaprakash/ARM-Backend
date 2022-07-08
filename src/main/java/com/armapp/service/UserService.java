package com.armapp.service;

import com.armapp.model.User;
import com.armapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @PostConstruct   // it will initialize the user in the runtime
    public void initializeUser(){
        userRepo.saveAll(Stream.of(
                new User(1, "Baba"),
                new User(2, "Dibya"),
                new User(3, "Awadhesh"))
                .collect(Collectors.toList()));
    }

    // getting the user by id
    public User getUser(int id){
        return  userRepo.findById(id).orElse(null);
    }

    // getting all users
    public List<User> getAll(){
        return userRepo.findAll();
    }

}
