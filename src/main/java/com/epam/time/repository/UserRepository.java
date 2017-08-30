package com.epam.time.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epam.time.model.User;



public interface UserRepository extends JpaRepository<User, Long> {
	
	
	/* @Query("SELECT u FROM User u WHERE u.userName=userName")*/
	
	// public List<User> findByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

	 public List<User> findByUserNameAndPassword(String userName, String password);

		
}
