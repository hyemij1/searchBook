package com.example.searchBook.User.repository;

import com.example.searchBook.User.model.User;

public interface UserRepositoryCustom {

	User findByUserName(String userName);
	
	void saveUser(User user);
	
}
