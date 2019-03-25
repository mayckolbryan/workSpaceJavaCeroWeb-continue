package com.mitocode.test.unit;

import org.junit.Assert;
import org.junit.Test;

import com.mitocode.model.entity.Category;
import com.mitocode.model.repository.CategoryRepository;
import com.mitocode.model.repository.impl.CategoryRepositoryImpl;

public class CategoryTest {

//	@Inject
//	private CategoryRepository categoryRepositoryImpl;
	private CategoryRepository categoryRepositoryImpl = new CategoryRepositoryImpl();
	private Category category = new Category();
	
	@Test
	public void insert() throws Exception {
		try {
			System.out.println("Test Unit Category");
			category.setName("CHOCOLATE");
			category = categoryRepositoryImpl.insert(category);
			
			Assert.assertTrue(category.getId() > 0);
		} catch (Exception e) {
			Assert.fail();
		}
	}
}
