package com.example.demo;

import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user){
        System.out.println(user);
        user = new User();
        user.setUsername("wangwu");
        return user;
    }
}
