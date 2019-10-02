package com.example.demo.service;

import com.example.demo.pojo.User;

public interface CustomUserService {

    User getById(Integer id);

    User save(User user);

    void delete(Integer id);
}
