package com.hampcode.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.hampcode.service.ICategoryService;
import com.hampcode.service.IProductService;
import com.hampcode.model.entity.Category;
import com.hampcode.model.entity.Product;
import com.hampcode.util.Message;

@Named
@ViewScoped
public class ProductController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ICategoryService categoryService;

	@Inject
	private IProductService productService;

	private Product product;
	private Product productSel;
	private List<Product> products;

	private Category category;
	private List<Category> categories;

	@PostConstruct
	public void init() {
		product = new Product();
		productSel = new Product();

		this.loadProducts();
		this.loadCategories();
	}

	public void loadCategories() {
		try {
			this.categories = categoryService.findAll();
		} catch (Exception e) {

		}
	}

	public void loadProducts() {
		try {
			this.products = productService.findAll();
		} catch (Exception e) {

		}
	}

	public void saveProduct() {
		try {
			if (product.getId() != 0) {
				product.setCategory(category);
				productService.update(product);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				product.setCategory(category);
				productService.insert(product);
				Message.messageInfo("Registro guardado exitosamente");

			}
			loadProducts();
			cleanForm();
		} catch (Exception e) {
			Message.messageError("Error ProductoType :" + e.getMessage());
		}
	}

	public void editProduct() {
		try {
			if (this.productSel.getId() > 0) {
				this.product = this.productSel;
				// this.product.setProductType(this.productSel.getProductType());
			} else {
				Message.messageInfo("Debe seleccionar un  producto");
			}
		} catch (Exception e) {
			Message.messageError("Error Product :" + e.getMessage());
		}

	}

	public void selecProduct(SelectEvent e) {
		this.productSel = (Product) e.getObject();
	}

	public void cleanForm() {
		this.product = new Product();
		this.productSel = null;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Product getProductSel() {
		return productSel;
	}

	public void setProductSel(Product productSel) {
		this.productSel = productSel;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
