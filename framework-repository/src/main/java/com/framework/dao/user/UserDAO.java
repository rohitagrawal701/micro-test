package com.framework.dao.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.framework.collection.User;
import com.framework.repository.user.UserRepository;

@Repository
public class UserDAO {

	@Autowired
	UserRepository userRepository;

	public User insertUser(User user) {
		userRepository.insert(user);
		return user;
	}

	public User getUserById(String userId) {
		return userRepository.findOne(userId);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public boolean deleteUser(String userId) {
		return userRepository.deleteUserWithChildren(userId);
	}

	public User updateUser(User user) {
		userRepository.save(user);
		return user;
	}

}
