package com.hampcode.model.repository.impl;

import java.io.Serializable;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hampcode.model.entity.Order;
import com.hampcode.model.entity.Status;
import com.hampcode.model.repository.IOrderRepository;

@Named
public class OrderRepositoryImpl implements IOrderRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "visorPU")
	private EntityManager em;

	@Override
	public Integer insert(Order t) throws Exception {
		t.setState(Status.ISSUED.getCodeStatus());
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer update(Order t) throws Exception {
		// TODO
		return null;
	}

	@Override
	public Integer delete(Order t) throws Exception {
		// TODO
		return null;
	}

	@Override
	public List<Order> findAll() throws Exception {
		// TODO
		return null;
	}

	@Override
	public Order findById(Order t) throws Exception {
		// TODO
		return null;
	}

}