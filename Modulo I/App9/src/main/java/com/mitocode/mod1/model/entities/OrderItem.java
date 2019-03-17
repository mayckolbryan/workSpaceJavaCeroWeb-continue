package com.mitocode.mod1.model.entities;

public class OrderItem {
	private Integer quantity;
	private Double price;
	
	private Product product;

	/**
	 * @param quantity
	 * @param price
	 * @param product
	 */
	public OrderItem(Integer quantity, Double price, Product product) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double subTotal() {
		return this.price * this.quantity;
	}
	
	@Override
	public String toString() {
		return product.getName() + ", $" + String.format("%.2f", price) + ", Quantity: " + quantity + ", Subtotal: $"
				+ String.format("%.2f", subTotal());
	}
}
