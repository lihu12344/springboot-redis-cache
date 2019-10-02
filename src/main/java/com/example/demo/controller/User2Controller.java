package com.example.demo.controller;


import com.example.demo.pojo.User;
import com.example.demo.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lihu
 * @since 2019-10-02
 */
@RestController
@RequestMapping("/user")
public class User2Controller {

    @Autowired
    private CustomUserService userService;

    @RequestMapping("/get/{id}")
    public User get(@PathVariable("id") Integer id){
        return userService.getById(id);
    }

    @RequestMapping("/save")
    public User save(){
        User user=new User();
        user.setName("瓜田李下");
        user.setAge(24);

        userService.save(user);

        return user;
    }

    @RequestMapping("/delete")
    public User delete(){
        User user=userService.getById(2);
        userService.delete(user.getId());

        return user;
    }
}