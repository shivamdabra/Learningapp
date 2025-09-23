package com.example.RESTapi.Controller;


import com.example.RESTapi.Entity.User;
import com.example.RESTapi.Service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping()
    public String updateByUserName(@RequestBody User newuser) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.findByuserName(userName);
                user.setUserName(newuser.getUserName());
                user.setPassword(newuser.getPassword());
                userService.saveUser(user);
            return "Everything is bad";
        }
    }
