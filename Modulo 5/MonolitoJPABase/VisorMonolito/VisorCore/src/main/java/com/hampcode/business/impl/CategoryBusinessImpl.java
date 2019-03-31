package com.hampcode.business.impl;

import java.io.Serializable;
import java.util.List;


import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.business.CategoryBusiness;

import com.hampcode.model.entity.Category;
import com.hampcode.model.repository.CategoryRepository;

@Named
public class CategoryBusinessImpl implements CategoryBusiness, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CategoryRepository categoryRepository;

	@Override
	@Transactional
	public Integer insert(Category t) throws Exception {
		return categoryRepository.insert(t);
	}

	@Override
	@Transactional
	public Integer update(Category t) throws Exception {
		return categoryRepository.update(t);
	}

	@Override
	@Transactional
	public Integer delete(Category t) throws Exception {
		return categoryRepository.delete(t);
	}

	@Override
	public List<Category> list() throws Exception {
		return categoryRepository.list();
	}

	@Override
	public Category findById(Category t) throws Exception {
		return categoryRepository.findById(t);
	}

}
