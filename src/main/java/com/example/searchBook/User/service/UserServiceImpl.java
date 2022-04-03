package com.example.searchBook.User.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.searchBook.User.model.User;
import com.example.searchBook.User.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUserName(username);
	}

	@Transactional
	@Override
	public void saveUser(User user) {
		userRepository.saveUser(user);
	}

}
