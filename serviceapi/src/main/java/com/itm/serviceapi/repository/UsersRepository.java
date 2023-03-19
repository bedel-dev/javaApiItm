package com.itm.serviceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itm.serviceapi.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
	  Boolean existsByUsername(String username);

	  Boolean existsByPass(String pass);
}
