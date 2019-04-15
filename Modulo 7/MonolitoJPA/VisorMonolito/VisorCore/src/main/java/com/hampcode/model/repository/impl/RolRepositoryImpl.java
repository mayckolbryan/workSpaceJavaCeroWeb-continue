package com.hampcode.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hampcode.model.entity.Rol;
import com.hampcode.model.entity.User;
import com.hampcode.model.entity.UserRol;
import com.hampcode.model.repository.RolRepository;

@Named
public class RolRepositoryImpl implements RolRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "visorPU")
	private EntityManager em;

	@Override
	public Integer insert(Rol t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer update(Rol t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer delete(Rol t) throws Exception {
		em.remove(t);
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rol> findAll() throws Exception {
		List<Rol> roles = new ArrayList<>();

		Query q = em.createQuery("SELECT r FROM Rol r");
		roles = (List<Rol>) q.getResultList();
		return roles;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Rol findById(Rol t) throws Exception {

		List<Rol> roles = new ArrayList<>();
		Query query = em.createQuery("FROM Rol r where r.id = ?1");
		query.setParameter(1, t.getId());

		roles = (List<Rol>) query.getResultList();

		return roles != null && !roles.isEmpty() ? roles.get(0) : new Rol();
	}

	@Override
	public Integer insertUserRole(List<UserRol> userRoles) throws Exception {
		// TODO
		return 1;
	}

	
	@Override
	public List<UserRol> findUserRolesByUser(User user) throws Exception {
		List<UserRol> userRoles = new ArrayList<UserRol>();

		//TODO
		return userRoles;
	}

}
