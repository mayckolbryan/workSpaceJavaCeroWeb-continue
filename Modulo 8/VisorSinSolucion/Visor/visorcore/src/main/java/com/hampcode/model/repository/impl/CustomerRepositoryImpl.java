package com.hampcode.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Customer;
import com.hampcode.model.repository.ICustomerRepository;

@Named
public class CustomerRepositoryImpl implements ICustomerRepository, Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "visorPU")
	private EntityManager em;

	@Override
	public Integer insert(Customer t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer update(Customer t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer delete(Customer t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Customer> findAll() throws Exception {
		List<Customer> customers = new ArrayList<>();

		TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c", Customer.class);
		customers = query.getResultList();
		return customers;
	}

	@Override
	public Customer findById(Customer t) throws Exception {
		List<Customer> customers = new ArrayList<>();
		TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.id = ?1", Customer.class);
		query.setParameter(1, t.getId());

		customers = query.getResultList();

		return customers != null && !customers.isEmpty() ? customers.get(0) : new Customer();
	}

	@Override
	public Optional<Customer> findByDni(String dni) throws Exception {
		Customer customer;
		TypedQuery<Customer> customerFound = em.createQuery("Select c from Customer c  WHERE c.dni =?1",
				Customer.class);
		customerFound.setParameter(1, dni);
		customer = customerFound.getSingleResult();

		return Optional.of(customer);
	}

}