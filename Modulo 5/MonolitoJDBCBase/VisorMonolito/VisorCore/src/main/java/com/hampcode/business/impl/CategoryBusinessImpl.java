package com.hampcode.business.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.business.CategoryBusiness;

import com.hampcode.model.entity.Category;
import com.hampcode.model.repository.CategoryRepository;
//import com.hampcode.model.repository.impl.CategoryRepositoryImpl;

@Named
public class CategoryBusinessImpl implements CategoryBusiness,Serializable {


	private static final long serialVersionUID = 1L;
	
	@Inject
	private CategoryRepository categoryRepository;
	
	/*public CategoryBusinessImpl() {
		categoryRepository = new CategoryRepositoryImpl();
	}*/

	@Transactional
	@Override
	public Category insert(Category t) throws Exception {
		return categoryRepository.insert(t);
	}

	@Transactional
	@Override
	public Category update(Category t) throws Exception {
		return categoryRepository.update(t);
	}

	@Transactional
	@Override
	public Category delete(Category t) throws Exception {
		return categoryRepository.delete(t);
	}

	@Override
	public Optional<Category> find(Category t) throws Exception {
		return categoryRepository.find(t);
	}

	@Override
	public List<Category> findAll() throws Exception {
		return categoryRepository.findAll();
	}

}
