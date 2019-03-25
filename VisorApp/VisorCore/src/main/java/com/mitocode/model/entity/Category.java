/**
 * 
 */
package com.mitocode.model.entity;

import java.io.Serializable;

/**
 * @author Usuario
 *
 */
public class Category implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}