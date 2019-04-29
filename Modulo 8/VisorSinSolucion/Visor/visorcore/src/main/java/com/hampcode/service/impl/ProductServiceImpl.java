package com.hampcode.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.service.IProductService;
import com.hampcode.dto.ReportProductCategory;
import com.hampcode.model.entity.Product;
import com.hampcode.model.repository.IProductRepository;

@Named
public class ProductServiceImpl implements IProductService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IProductRepository productRepository;

	@Transactional
	@Override
	public Integer insert(Product t) throws Exception {
		return productRepository.insert(t);
	}

	@Transactional
	@Override
	public Integer update(Product t) throws Exception {
		return productRepository.update(t);
	}

	@Transactional
	@Override
	public Integer delete(Product t) throws Exception {
		return productRepository.delete(t);
	}

	@Override
	public List<Product> findAll() throws Exception {
		return productRepository.findAll();
	}

	@Override
	public Product findById(Product t) throws Exception {
		return productRepository.findById(t);
	}

	@Override
	public List<ReportProductCategory> reportQuantityProductByCategory() {
		return productRepository.reportQuantityProductByCategory();
	}

}
