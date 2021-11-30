package com.rst.mywallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rst.mywallet.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByuserId(final long userId);
	
}
