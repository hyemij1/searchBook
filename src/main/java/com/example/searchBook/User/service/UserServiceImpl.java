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
		validateUser(user.getUsername());
		userRepository.saveUser(user);
	}

	@Override
	public void validateUser(String username) {

		User result = userRepository.findByUserName(username);

		if (result != null && username.equals(result.getUsername())) {
			throw new IllegalStateException("이미 존재하는 사용자명입니다.");
		}

	}

}
