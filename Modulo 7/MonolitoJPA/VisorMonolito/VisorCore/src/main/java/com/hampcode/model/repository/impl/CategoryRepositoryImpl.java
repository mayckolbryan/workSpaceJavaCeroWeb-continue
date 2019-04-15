package com.hampcode.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Category;
import com.hampcode.model.repository.CategoryRepository;


@Named
public class CategoryRepositoryImpl implements CategoryRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "visorPU")
	private EntityManager em;

	@Override
	public Integer insert(Category t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer update(Category t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer delete(Category t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Category> findAll() throws Exception {
		List<Category> categories = new ArrayList<>();

		TypedQuery<Category> query = em.createQuery("SELECT c FROM Category c", Category.class);
		categories = query.getResultList();
		return categories;
	}

	@Override
	public Category findById(Category t) throws Exception {
		List<Category> categories = new ArrayList<>();
		TypedQuery<Category> query = em.createQuery("SELECT c FROM Category c where c.id = ?1", Category.class);
		query.setParameter(1, t.getId());

		categories = query.getResultList();

		return categories != null && !categories.isEmpty() ? categories.get(0) : new Category();
	}

	@Override
	public List<Category> findByName(String name) throws Exception {
		return em.createQuery("SELECT c FROM Category c WHERE name LIKE :name", Category.class)
				.setParameter("name", "%" + name.toUpperCase() + "%").getResultList();
	}

}
