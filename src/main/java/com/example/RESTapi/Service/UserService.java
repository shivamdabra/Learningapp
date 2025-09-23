package com.example.RESTapi.Service;

import com.example.RESTapi.Entity.User;
import com.example.RESTapi.Repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService {

    @Autowired
    public UserRepo userRepo;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public void saveUser(User user){
        userRepo.save(user);
    }
    public void saveNewUser(User user){
        try {
            user.setPassword(passwordEncoder.encode(user.getUserName()));
            user.setRoles(List.of("USER"));
            userRepo.save(user);
        }catch (Exception exception) {
            log.error("i am a error");
            log.info("i am a info");
            log.warn("i am warn");
            log.debug("i am debug");
            log.trace("i am trace");

        }
    }
    public void saveNewAdmin(User user){
        user.setPassword(passwordEncoder.encode(user.getUserName()));
        user.setRoles(Arrays.asList("USER","ADMIN"));
        userRepo.save(user);
    }
    public List<User> findAll(){
        return userRepo.findAll();
    }
    public Optional<User> findById(ObjectId id){
        return userRepo.findById(id);
    }
    public void deleteById(ObjectId id){
        userRepo.deleteById(id);
    }
    public User findByuserName(String userName){
        return userRepo.findByuserName(userName);
    }
}
