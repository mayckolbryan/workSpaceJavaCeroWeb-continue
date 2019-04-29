package com.hampcode.service;

import java.util.List;

import com.hampcode.dto.ReportProductCategory;
import com.hampcode.model.entity.Product;

public interface IProductService extends CrudService<Product> {
	 List<ReportProductCategory> reportQuantityProductByCategory() ;

}
