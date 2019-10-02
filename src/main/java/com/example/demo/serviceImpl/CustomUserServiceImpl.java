package com.example.demo.serviceImpl;

import com.example.demo.dao.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CustomUserServiceImpl implements CustomUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Cacheable(value = "custom",keyGenerator = "keyGenerator")
    public User getById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    @CachePut(value = "default",key="#result.id")
    public User save(User user) {
        userMapper.insert(user);
        return user;
    }

    @Override
    @CacheEvict(value = "custom",keyGenerator = "keyGenerator")
    public void delete(Integer id) {
        userMapper.deleteById(id);
    }
}
