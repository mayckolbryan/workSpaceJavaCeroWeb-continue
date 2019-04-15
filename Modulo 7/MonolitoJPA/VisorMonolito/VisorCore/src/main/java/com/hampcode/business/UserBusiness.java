package com.hampcode.business;

import java.util.Optional;

import com.hampcode.model.entity.User;

public interface UserBusiness extends CrudBusiness<User> {

	
	Optional<User> authentication(User us) throws Exception;
}