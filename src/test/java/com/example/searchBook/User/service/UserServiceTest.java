package com.example.searchBook.User.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.searchBook.User.model.User;

@SpringBootTest
@Transactional
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	void findUser() {
		User user = userService.findByUsername("user");
		assertThat(user.getUsername()).as("##### findByUsername Test").isEqualTo("user");
	}

	@Test
	void saveUser() {

		User user = new User();
		user.setId(null);
		user.setUsername("user0");
		user.setPassword("1234");
		userService.saveUser(user);

		User result = userService.findByUsername(user.getUsername());
		assertThat(user).as("##### saveUser Test").isEqualTo(result);

	}

}
