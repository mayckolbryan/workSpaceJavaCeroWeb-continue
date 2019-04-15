package com.hampcode.business.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.business.RolBusiness;
import com.hampcode.model.entity.Rol;
import com.hampcode.model.entity.User;
import com.hampcode.model.entity.UserRol;
import com.hampcode.model.repository.RolRepository;

@Named
public class RolBusinessImpl implements RolBusiness, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private RolRepository rolRepository;

	@Transactional
	@Override
	public Integer insert(Rol t) throws Exception {
		return rolRepository.insert(t);
	}

	@Transactional
	@Override
	public Integer update(Rol t) throws Exception {
		return rolRepository.update(t);
	}

	@Transactional
	@Override
	public Integer delete(Rol t) throws Exception {
		return rolRepository.delete(t);
	}

	@Override
	public List<Rol> findAll() throws Exception {
		return rolRepository.findAll();
	}

	@Override
	public Rol findById(Rol t) throws Exception {
		return rolRepository.findById(t);
	}

	@Transactional
	@Override
	public Integer assignRolesToUser(User user, List<Rol> roles) throws Exception {
		List<UserRol> userRoles = new ArrayList<>();

		roles.forEach(rol -> {
			UserRol userRol = new UserRol();
			userRol.setUserId(user);
			userRol.setRolId(rol);
			userRoles.add(userRol);
		});

		rolRepository.insertUserRole(userRoles);

		return 1;
	}

	@Override
	public List<UserRol> findUserRolesByUser(User user) throws Exception {
		return rolRepository.findUserRolesByUser(user);
	}

}
