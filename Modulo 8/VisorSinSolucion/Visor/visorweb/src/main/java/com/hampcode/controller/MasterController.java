package com.hampcode.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hampcode.model.entity.User;
import com.hampcode.model.entity.UserRol;
import com.hampcode.service.IRolService;

@Named
@ViewScoped
public class MasterController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IRolService rolService;

	public void checkSesion() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			User user = (User) context.getExternalContext().getSessionMap().get("user");

			if (user == null) {
				context.getExternalContext().redirect("./../index.xhtml");
			}else {
				
				String viewId = context.getViewRoot().getViewId();
				System.out.println("VIEW ID:"+viewId);
				
				boolean rpta = checkMenu(viewId);
				
				if(!rpta) {
					context.getExternalContext().redirect("./../403.xhtml");
				}
			}	

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public boolean checkMenu(String viewId) {

		try {
			FacesContext context = FacesContext.getCurrentInstance();
			User user = (User) context.getExternalContext().getSessionMap().get("user");
			
			System.out.println("USER :"+user.toString());

			List<UserRol> userRoles = rolService.findRolesByUser(user);
			
			for (UserRol userRol2 : userRoles) {
				System.out.println("USERROLE :"+userRol2.getUserId().getCustomer().getName());
			}
			

			String typeRol = "";
			switch (viewId) {
			case "/protected/orders.xhtml":
				typeRol = "USER";
				break;
			case "/protected/asignarroleuser.xhtml":
				typeRol = "ADMIN";
				break;
			case "/protected/categorys.xhtml":
				typeRol = "ADMIN,USER";
				break;
			case "/protected/products.xhtml":
				typeRol = "ADMIN,USER";
				break;
			case "/protegido/roles.xhtml":
				typeRol = "ADMIN";
				break;

			default:
				break;
			}

			String typeRoles[] = typeRol.split(",");

			int[] count = { 0 };
			userRoles.forEach(userRol -> {
				for (String typeRoleFound : typeRoles) {
					if (userRol.getRolId().getType().equals(typeRoleFound)) {
						count[0]++;
					}
				}
			});

			if (count[0] == 0) {
				return false;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return true;
	}

	public void signOut() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}

}
