package com.hampcode.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hampcode.business.CustomerBusiness;
import com.hampcode.business.RolBusiness;
import com.hampcode.model.entity.Customer;

import com.hampcode.model.entity.User;

@Named
@ViewScoped
public class RegisterController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CustomerBusiness customerBusiness;

	@Inject
	private RolBusiness rolBusiness;

	private Customer customer;
	private User user;

	@PostConstruct
	public void init() {
		this.customer = new Customer();
		this.user = new User();
	}

	public String registerUser() {
		String redirect = null;

		// TODO

		return redirect;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
