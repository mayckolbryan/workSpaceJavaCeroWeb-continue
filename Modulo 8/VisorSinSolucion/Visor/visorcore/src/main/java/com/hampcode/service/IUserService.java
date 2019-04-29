package com.hampcode.service;

import java.util.Optional;

import com.hampcode.model.entity.User;

public interface IUserService extends CrudService<User> {

	Optional<User> authentication(User user) throws Exception;
}