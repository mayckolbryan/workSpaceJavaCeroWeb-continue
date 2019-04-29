package com.hampcode.controller;

import java.io.Serializable;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hampcode.model.entity.User;
import com.hampcode.service.IUserService;
import com.hampcode.util.Message;

@Named
@ViewScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IUserService userService;
	private User user;

	@PostConstruct
	public void init() {
		this.user = new User();
	}

	public String authentication() {
		String redirect = null;

		try {
			Optional<User> userFound = userService.authentication(user);

			if (userFound.isPresent() && userFound.get().getState().equalsIgnoreCase("A")) {

				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
				redirect = "/protected/orders?faces-redirect=true";
			} else {
				Message.messageError("Credenciales incorrectas");

			}
		} catch (Exception e) {
			Message.messageError("Credenciales incorrectas" + e.getMessage());
			System.out.println(e.getMessage());
		}

		return redirect;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
