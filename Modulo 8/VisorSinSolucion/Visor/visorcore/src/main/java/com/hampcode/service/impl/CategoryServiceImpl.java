package com.hampcode.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Category;
import com.hampcode.model.repository.ICategoryRepository;
import com.hampcode.service.ICategoryService;

@Named
public class CategoryServiceImpl implements ICategoryService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ICategoryRepository categoryRepository;

	
	@Transactional
	@Override
	public Integer insert(Category t) throws Exception {
		return categoryRepository.insert(t);
	}

	@Transactional
	@Override	
	public Integer update(Category t) throws Exception {
		return categoryRepository.update(t);
	}

	@Transactional
	@Override
	public Integer delete(Category t) throws Exception {
		return categoryRepository.delete(t);
	}

	@Override
	public List<Category> findAll() throws Exception {
		return categoryRepository.findAll();
	}

	@Override
	public Category findById(Category t) throws Exception {
		return categoryRepository.findById(t);
	}

}
