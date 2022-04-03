package com.example.searchBook.User.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.searchBook.User.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom{
	
}
