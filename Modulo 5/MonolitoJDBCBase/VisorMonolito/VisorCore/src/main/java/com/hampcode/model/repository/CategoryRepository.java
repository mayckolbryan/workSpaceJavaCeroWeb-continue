package com.hampcode.model.repository;

import java.util.List;

import com.hampcode.model.entity.Category;

public interface CategoryRepository extends JdbcRepository<Category> {

	List<Category> findByName(String name) throws Exception;

}
