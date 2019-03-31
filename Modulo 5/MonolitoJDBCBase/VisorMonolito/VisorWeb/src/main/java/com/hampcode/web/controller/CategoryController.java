/**
 * 
 */
package com.hampcode.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hampcode.business.CategoryBusiness;
import com.hampcode.model.entity.Category;

/**
 * @author Usuario
 *
 */
@Named
@ViewScoped
public class CategoryController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private CategoryBusiness categoryBusiness;
	
	private Category category;
	private List<Category> categories;
	
	@PostConstruct
	public void init() {
		category = new Category();
		categories = new ArrayList<Category>();
		this.loadCategories();
	}
	
	public void loadCategories() {
		try {
			this.categories = categoryBusiness.findAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void saveOrUpdateCategory() {
		try {
			if (category.getId() != null) {
				
			}else {
				categoryBusiness.insert(category);
			}
			loadCategories();
			cleanForm();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void cleanForm() {
		category = new Category();
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
}
