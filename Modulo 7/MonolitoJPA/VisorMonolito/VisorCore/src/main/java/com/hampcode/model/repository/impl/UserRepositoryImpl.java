package com.hampcode.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hampcode.model.entity.User;
import com.hampcode.model.repository.UserRepository;

@Named
public class UserRepositoryImpl implements UserRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "visorPU")
	private EntityManager em;

	@Override
	public Integer insert(User t) throws Exception {
		em.persist(t);
		return t.getCustomer().getId();
	}

	@Override
	public Integer update(User t) throws Exception {
		em.merge(t);
		return t.getCustomer().getId();
	}

	@Override
	public Integer delete(User t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() throws Exception {
		List<User> users = new ArrayList<>();

		Query query = em.createQuery("SELECT c FROM User c");
		users = (List<User>) query.getResultList();

		return users;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findById(User t) throws Exception {
		User user = new User();
		List<User> users = new ArrayList<>();

		Query query = em.createQuery("FROM User c WHERE c.id=?1");
		query.setParameter(1, t.getCustomer().getId());

		users = (List<User>) query.getResultList();

		if (users != null && !users.isEmpty()) {
			user = users.get(0);
		}

		return user;
	}


	@Override
	public String getPassworHashedByUserName(String username) throws Exception {
		User user = new User();
		
		//TODO

		return user != null ? user.getPassword() : "";
	}

	
	@Override
	public Optional<User> findUserByUsername(User user) throws Exception {
		User u = new User();
		
		
		
		//TODO

		return Optional.of(u);
	}

}
