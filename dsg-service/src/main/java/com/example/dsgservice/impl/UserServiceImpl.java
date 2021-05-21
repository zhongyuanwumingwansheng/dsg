package com.example.dsgservice.impl;

import com.example.dsgdao.User;
import com.example.dsgservice.UserService;
import com.example.dsgdao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addOne(User demo){
        return userRepository.save(demo);
    }

    @Override
    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

}
