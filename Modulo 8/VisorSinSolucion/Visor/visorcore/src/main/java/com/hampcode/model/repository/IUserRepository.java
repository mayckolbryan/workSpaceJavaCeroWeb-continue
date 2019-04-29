package com.hampcode.model.repository;

import java.util.Optional;

import com.hampcode.model.entity.User;

public interface IUserRepository extends JpaRepository<User> {

	String getPassworHashedByUserName(String username) throws Exception;

	Optional<User> findByUsername(User user) throws Exception;
}
