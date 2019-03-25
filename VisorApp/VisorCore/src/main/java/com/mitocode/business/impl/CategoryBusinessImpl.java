package com.mitocode.business.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import com.mitocode.business.CategoryBusiness;
import com.mitocode.model.entity.Category;
import com.mitocode.model.repository.CategoryRepository;

@Named
public class CategoryBusinessImpl implements CategoryBusiness, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	CategoryRepository categoryRepository;
	
//	public CategoryBusinessImpl() {
//		this.categoryRepository = new CategoryRepositoryImpl();
//	}

	@Override
	public Category insert(Category t) throws Exception {
		return categoryRepository.insert(t);
	}

	@Override
	public Category update(Category t) throws Exception {
		return categoryRepository.update(t);
	}

	@Override
	public Category delete(Category t) throws Exception {
		return categoryRepository.delete(t);
	}

	@Override
	public Optional<Category> find(Category t) throws Exception {
		return categoryRepository.find(t);
	}

	@Override
	public List<Category> getAll() throws Exception {
		return categoryRepository.getAll();
	}

}
