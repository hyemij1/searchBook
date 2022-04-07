package com.example.searchBook.User.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.searchBook.User.model.User;

import java.util.List;

public class UserRepositoryImpl implements UserRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User findByUserName(String userName) {

		TypedQuery<User> query = entityManager.createQuery(
				"select u from User u where u.username = :username", User.class);
		query.setParameter("username", userName);

		List<User> resultList = query.getResultList();

		return resultList.stream().findAny().orElse(null);
	}

	@Override
	public void saveUser(User user) {

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

		entityManager.persist(user);

	}

}