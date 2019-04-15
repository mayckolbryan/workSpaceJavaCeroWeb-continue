package com.hampcode.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hampcode.business.UserBusiness;
import com.hampcode.model.entity.User;

@Named
@ViewScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UserBusiness userBusiness;
	private User user;

	@PostConstruct
	public void init() {
		this.user = new User();
	}

	public String authentication() {
		String redirect = null;

		redirect = "/protected/orders?faces-redirect=true";

		return redirect;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
