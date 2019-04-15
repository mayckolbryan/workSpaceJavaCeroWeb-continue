package com.hampcode.business.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.business.CustomerBusiness;
import com.hampcode.model.entity.Customer;
import com.hampcode.model.repository.CustomerRepository;


@Named
public class CustomerBusinessImpl implements CustomerBusiness,Serializable {


	private static final long serialVersionUID = 1L;
	@Inject
	private CustomerRepository customerRepository;

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
	public List<Customer> findCustomerByName(String name) throws Exception {
		return customerRepository.findByName(name);
	}

	@Override
	public Optional<Customer> findCustomerByDni(String dni) throws Exception {
		return customerRepository.findByDni(dni);
	}
}
