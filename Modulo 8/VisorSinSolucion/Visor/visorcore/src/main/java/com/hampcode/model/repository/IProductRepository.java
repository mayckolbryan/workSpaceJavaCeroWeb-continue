package com.hampcode.model.repository;

import java.util.List;

import com.hampcode.dto.ReportProductCategory;
import com.hampcode.model.entity.Product;

public interface IProductRepository extends JpaRepository<Product> {
	
	 List<ReportProductCategory> reportQuantityProductByCategory();

}

