package com.example.RESTapi.Repository;

import com.example.RESTapi.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, ObjectId> {
  User findByuserName(String userName);
}
