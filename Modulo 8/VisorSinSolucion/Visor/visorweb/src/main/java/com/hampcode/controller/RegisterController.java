package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.mindrot.jbcrypt.BCrypt;

import com.hampcode.model.entity.Customer;
import com.hampcode.model.entity.Rol;
import com.hampcode.model.entity.User;
import com.hampcode.service.ICustomerService;
import com.hampcode.service.IRolService;

@Named
@ViewScoped
public class RegisterController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ICustomerService customerService;

	@Inject
	private IRolService rolService;

	private Customer customer;
	private User user;

	@PostConstruct
	public void init() {
		customer = new Customer();
		this.user = new User();
	}

	public String registerUser() {
		String redirect = null;

		try {
			String password = this.user.getPassword();
			String passwordHashed = BCrypt.hashpw(password, BCrypt.gensalt());

			//User
			this.user.setPassword(passwordHashed);
			this.user.setState("A");

			//User<---> Customer
			this.customer.setUser(this.user);
			this.user.setCustomer(this.customer);
			
			this.customerService.insert(this.customer);
			

			//Roles
			List<Rol> roles = new ArrayList<Rol>();
			int rolId = 1;
			Rol rol = new Rol();
			rol.setId(rolId);

			roles.add(rol);

			//Roles-->User
			rolService.assignRolesToUser(this.user, roles);

			redirect = "index?faces-redirect=true";
		} catch (Exception e) {

		}
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
