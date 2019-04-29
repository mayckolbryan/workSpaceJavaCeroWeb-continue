package com.hampcode.dto;

import java.io.Serializable;

public class ReportProductCategory implements Serializable {

	private static final long serialVersionUID = 1L;
	private int quantity;
	private String category;

	public ReportProductCategory() {
	}

	public ReportProductCategory(int quantity, String category) {
		this.quantity = quantity;
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
