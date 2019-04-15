package com.hampcode.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.hampcode.business.RolBusiness;
import com.hampcode.model.entity.User;
import com.hampcode.model.entity.UserRol;

public class MasterController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private RolBusiness rolBusiness;

	public void checkSesion() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			User user = (User) context.getExternalContext().getSessionMap().get("userAuthenticated");

			if (user == null) {
				context.getExternalContext().redirect("./../index.xhtml");
			} else {
				// verificacion de roles
				String viewId = context.getViewRoot().getViewId();
				boolean rpta = this.checkMenuByRol(viewId);

				if (!rpta) {
					context.getExternalContext().redirect("./../403.xhtml");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public boolean checkMenuByRol(String viewId) {
		FacesContext context = FacesContext.getCurrentInstance();
		User user = (User) context.getExternalContext().getSessionMap().get("userAuthenticated");

		try {
			List<UserRol> roles = rolBusiness.findUserRolesByUser(user);
			String typeRoles = "";

			switch (viewId) {
			case "/protected/customers.xhtml":
				typeRoles = "ADMIN,USER";
				break;
			case "/protected/products.xhtml":
				typeRoles = "ADMIN";
				break;
			case "/protected/categorys.xhtml":
				typeRoles = "ADMIN";
				break;
			case "/protected/orders.xhtml":
				typeRoles = "ADMIN,USER";
				break;
			default:
				break;
			}

			String arrayRoles[] = typeRoles.split(",");

			int[] countArray = { 0 };

			roles.forEach(rol -> {
				for (String typeRol : arrayRoles) {
					if (rol.getRolId().getType().equals(typeRol)) {
						countArray[0]++;
					}
				}

			});

			if (countArray[0] == 0) {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}

	public void signOut() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}

}
