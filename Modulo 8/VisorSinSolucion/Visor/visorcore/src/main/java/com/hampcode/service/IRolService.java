package com.hampcode.service;

import java.util.List;

import com.hampcode.model.entity.Rol;
import com.hampcode.model.entity.User;
import com.hampcode.model.entity.UserRol;


public interface IRolService extends CrudService<Rol> {
	Integer assignRolesToUser(User user, List<Rol> roles) throws Exception;
	
	List<UserRol> findRolesByUser(User user)throws Exception;

}