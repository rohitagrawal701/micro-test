package com.framework.repository.user;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.framework.collection.User;

public interface UserRepository extends MongoRepository<User, String>, UserRepositoryCustom{

}
