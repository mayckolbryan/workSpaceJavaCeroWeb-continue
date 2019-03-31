package com.hampcode.model.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import com.hampcode.model.entity.Category;
import com.hampcode.model.repository.CategoryRepository;

@Named
public class CategoryRepositoryImpl implements CategoryRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Integer insert(Category t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(Category t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(Category t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findById(Category t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
