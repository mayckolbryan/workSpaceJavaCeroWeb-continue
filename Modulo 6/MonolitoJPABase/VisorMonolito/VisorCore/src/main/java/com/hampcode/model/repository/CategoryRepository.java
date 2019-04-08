package com.hampcode.model.repository;

import java.util.List;

import com.hampcode.model.entity.Category;

public interface CategoryRepository extends JpaRepository<Category> {

	List<Category> findByName(String name) throws Exception;

}
