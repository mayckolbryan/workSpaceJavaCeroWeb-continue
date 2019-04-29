package com.hampcode.model.repository;

import java.util.List;

import com.hampcode.model.entity.Rol;
import com.hampcode.model.entity.User;
import com.hampcode.model.entity.UserRol;

public interface IRolRepository extends JpaRepository<Rol> {

	Integer insertUserRole(List<UserRol> userRoles) throws Exception;
	
	List<UserRol> findRolesByUser(User user)throws Exception;

}
