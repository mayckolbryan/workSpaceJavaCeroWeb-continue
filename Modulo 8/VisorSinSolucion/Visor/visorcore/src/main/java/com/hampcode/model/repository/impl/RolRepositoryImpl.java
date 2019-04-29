package com.hampcode.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Rol;
import com.hampcode.model.entity.User;
import com.hampcode.model.entity.UserRol;
import com.hampcode.model.repository.IRolRepository;

@Named
public class RolRepositoryImpl implements IRolRepository, Serializable {

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

	@Override
	public List<Rol> findAll() throws Exception {
		return null;
	}

	@Override
	public Rol findById(Rol t) throws Exception {

		return null;
	}

	@Override
	public Integer insertUserRole(List<UserRol> userRoles) throws Exception {

		int[] iarr = { 0 };

		userRoles.forEach(userRol -> {
			em.persist(userRol);

			if (iarr[0] % 100 == 0) {
				em.flush();
				em.clear();
			}
			iarr[0]++;
		});

		return 1;
	}

	@Override
	public List<UserRol> findRolesByUser(User user) throws Exception {
		List<UserRol> userRoles = new ArrayList<UserRol>();

		TypedQuery<UserRol> query = em.createQuery("SELECT ur FROM UserRol ur WHERE ur.userId.customer.id=?1",UserRol.class);
		query.setParameter(1, user.getCustomer().getId());

		userRoles = query.getResultList();

		return userRoles;
	}

}
