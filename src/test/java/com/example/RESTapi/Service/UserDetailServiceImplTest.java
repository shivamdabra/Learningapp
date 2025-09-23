package com.example.RESTapi.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.mockito.Mockito.*;

import com.example.RESTapi.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ActiveProfiles("dev")
@Disabled
public class UserDetailServiceImplTest {

    @InjectMocks
    private UserDetailServiceImpl userDetailService;

    @Mock
    private UserRepo userRepo;

    @Test
    void loadByUserNameTest(){
        Mockito.when(userRepo.findByuserName(ArgumentMatchers.anyString())).thenReturn((com.example.RESTapi.Entity.User) User.builder().username("ram").password("hady89").roles(String.valueOf(new ArrayList<>())).build());
        UserDetails user = userDetailService.loadUserByUsername("ram");
        Assertions.assertNotNull(user);
    }
}
