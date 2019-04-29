package com.hampcode.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.hampcode.dto.ReportProductCategory;
import com.hampcode.model.entity.Product;
import com.hampcode.model.repository.IProductRepository;



@Named
public class ProductRepositoryImpl implements IProductRepository,Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "visorPU")
	private EntityManager em;

	@Override
	public Integer insert(Product t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer update(Product t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer delete(Product t) throws Exception {
		em.remove(t);
		return 1;
	}


	@Override
	public List<Product> findAll() throws Exception {
		List<Product> products = new ArrayList<>();

		TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p",Product.class);
		products = query.getResultList();
		return products;
	}

	
	@Override
	public Product findById(Product t) throws Exception {

		List<Product> products = new ArrayList<>();
		TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.id = ?1",Product.class);
		query.setParameter(1, t.getId());

		products =  query.getResultList();

		return products != null && !products.isEmpty() ? products.get(0) : new Product();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReportProductCategory> reportQuantityProductByCategory() {
		List<ReportProductCategory> reportProductCategorys = new ArrayList<>();
		try {
			Query query = em.createNativeQuery("SELECT * FROM fn_QuantityProductByCategory()");
			// query.setParameter(1, per.getIdPersona());

		
			List<Object[]> data = query.getResultList();
			
			/*0) [1, Category 1]
			  1) [2, Category 2]
			  */

			data.forEach(x -> {
				int quantity = Integer.parseInt(String.valueOf(x[0]));
				String category = String.valueOf(x[1]);
				reportProductCategorys.add(new ReportProductCategory(quantity, category));
			});

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return reportProductCategorys;
	}

}
