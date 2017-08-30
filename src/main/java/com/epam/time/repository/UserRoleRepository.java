package com.epam.time.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.time.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> { 

}
