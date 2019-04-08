package com.hampcode.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.hampcode.business.CategoryBusiness;
import com.hampcode.model.entity.Category;
import com.hampcode.util.Message;

@Named
@ViewScoped
public class CategoryController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CategoryBusiness categoryBusiness;

	private Category category;
	private Category categorySelec;
	private List<Category> categorys;

	@PostConstruct
	public void init() {
		category = new Category();
		categorySelec = new Category();
		loadCategory();
	}

	public void loadCategory() {
		try {
			this.categorys = categoryBusiness.list();
		} catch (Exception e) {
			Message.messageError("Error Category :" + e.getMessage());
		}
	}

	public void saveCategory() {
		try {
			if (category.getId() != null) {

				Message.messageInfo("Registro actualizado exitosamente");
				categoryBusiness.update(category);
			} else {
				categoryBusiness.insert(category);
				Message.messageInfo("Registro guardado exitosamente");

			}
			loadCategory();
			clearForm();
		} catch (Exception e) {
			Message.messageError("Error Category :" + e.getStackTrace());
		}
	}

	public void editCategory() {
		try {
			if (this.categorySelec != null) {
				this.category = categorySelec;
			} else {
				Message.messageInfo("Debe seleccionar una categoria");
			}
		} catch (Exception e) {
			Message.messageError("Error Categoria :" + e.getMessage());
		}

	}

	public void deleteCategory() {
		try {
			if (this.categorySelec != null) {
				categoryBusiness.delete(categorySelec);
				loadCategory();
				clearForm();

			} else {

			}
		} catch (Exception e) {

		}
	}

	public void selectCategory(SelectEvent e) {
		this.categorySelec = (Category) e.getObject();
	}

	public void clearForm() {
		this.category = new Category();
		this.categorySelec = null;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Category getCategorySelec() {
		return categorySelec;
	}

	public void setCategorySelec(Category categorySelec) {
		this.categorySelec = categorySelec;
	}

	public List<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}

}
