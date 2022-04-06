package com.example.searchBook.User.service;

import com.example.searchBook.User.model.User;

public interface UserService {

	User findByUsername(String username);

	void saveUser(User user);

	void validateUser(String username);

}