package com.hampcode.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Customer;
import com.hampcode.model.repository.ICustomerRepository;
import com.hampcode.service.ICustomerService;

@Named
public class CustomerServiceImpl implements ICustomerService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ICustomerRepository customerRepository;

	@Transactional
	@Override
	public Integer insert(Customer t) throws Exception {
		return customerRepository.insert(t);
	}

	@Transactional
	@Override
	public Integer update(Customer t) throws Exception {
		return customerRepository.update(t);
	}

	@Transactional
	@Override
	public Integer delete(Customer t) throws Exception {
		return customerRepository.delete(t);
	}

	@Override
	public List<Customer> findAll() throws Exception {
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(Customer t) throws Exception {
		return customerRepository.findById(t);
	}

	@Override
	public Optional<Customer> findCustomerByDni(String dni) throws Exception {
		return customerRepository.findByDni(dni);
	}
}
