package com.example.RESTapi.Controller;

import com.example.RESTapi.Entity.User;
import com.example.RESTapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/all-users")
    public ResponseEntity<?> getalluser() {
        List<User> all = userService.findAll();
        if (all != null) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(all, HttpStatus.NOT_FOUND);
    }
    @PostMapping("/create-new-admin")
    public void createuser(@RequestBody User user){
        userService.saveNewAdmin(user);
    }

}
