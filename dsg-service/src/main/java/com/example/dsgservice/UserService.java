package com.example.dsgservice;

import com.example.dsgdao.User;
public interface UserService {

    User addOne(User demo);
    Iterable<User> findAll();
}
