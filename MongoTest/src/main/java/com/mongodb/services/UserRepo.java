package com.mongodb.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongodb.entities.User;
@Repository
public interface UserRepo extends MongoRepository<User, Integer>{
User findByName(String name);
}
