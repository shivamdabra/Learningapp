package com.example.RESTapi.Service;

import com.example.RESTapi.Entity.User;
import com.example.RESTapi.Repository.UserRepo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Disabled
public class ServiceTest {

    @Autowired
    private UserRepo userRepo;

    @Test
    public void testFindByUserName(){
       assertNotNull(userRepo.findByuserName("shivam"));
    }

    @ParameterizedTest
    @CsvSource({
      "1,1,2",
      "2,2,4",
      "3,3,6"
    })
    public void testaddittion(int a , int b, int expected){
        assertEquals(expected,a+b);
    }

}
