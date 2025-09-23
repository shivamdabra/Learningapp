package com.example.RESTapi.Controller;

import com.example.RESTapi.Entity.User;
import com.example.RESTapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    private UserService userService;

    @GetMapping("/health-check")
    public String healthCheck() {
        return "OK";
    }
    @PostMapping("/create-user")
    public String createUser(@RequestBody User newUser){
        userService.saveNewUser(newUser);
        return "Everything is Done!";
    }
}
