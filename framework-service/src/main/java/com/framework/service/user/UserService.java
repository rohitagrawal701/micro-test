package com.framework.service.user;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.framework.collection.User;
import com.framework.dao.user.UserDAO;
import com.framework.dto.user.UserDTO;

@Service
public class UserService {

	@Autowired
	DozerBeanMapper dozerBeanMapper;

	@Autowired
	UserDAO userDAO;

	public UserDTO insertUser(UserDTO userDTO) {
		try {
			final User user = new User();
			dozerBeanMapper.map(userDTO, user, "user-create-complete");
			dozerBeanMapper.map(userDAO.insertUser(user), userDTO);
		} catch (final Exception e) {
			System.out.println(e);
		}
		return userDTO;
	}

	public UserDTO getUserById(String userId) {
		final User user = userDAO.getUserById(userId);
		final UserDTO userDTO = new UserDTO();
		dozerBeanMapper.map(user, userDTO);
		return userDTO;
	}

	public List<UserDTO> getAllUsers() {
		final List<User> userList = userDAO.getAllUsers();
		final List<UserDTO> userDTOList = new ArrayList<>();
		for (final User user : userList) {
			final UserDTO userDTO = new UserDTO();
			dozerBeanMapper.map(user, userDTO);
			userDTOList.add(userDTO);
		}
		return userDTOList;
	}

	public boolean deleteUser(String userId) {
		return userDAO.deleteUser(userId);
	}

	@Transactional
	public UserDTO updateUser(UserDTO userDTO) {
		try {
			final User user = new User();
			dozerBeanMapper.map(userDTO, user);
			user.setAge(30);
			final User user2 = userDAO.updateUser(user);
			if(user2 != null) {
				throw new Exception();
			}
			user.setName("Prashant");
			userDAO.updateUser(user);
			dozerBeanMapper.map(user, userDTO);
		} catch (final Exception e) {
			throw new RuntimeException();

		}
		return userDTO;
	}

}
