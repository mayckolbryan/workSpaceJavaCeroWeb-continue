package com.hampcode.model.repository.impl;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Order;
import com.hampcode.model.entity.Status;
import com.hampcode.model.repository.OrderRepository;
import com.hampcode.util.Param;


@Named
public class OrderRepositoryImpl implements OrderRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "visorPU")
	private EntityManager em;

	@Override
	public Integer insert(Order t) throws Exception {
		t.setState(Status.ISSUED.getCodeStatus());
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer update(Order t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(Order t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findById(Order t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findOrder(String searchBy, String valueSearch) throws Exception {
		List<Order> orders = new ArrayList<>();

		TypedQuery<Order> orderExits = null;

		if (searchBy.equals(Param.CLIENTE.toString())) {
			orderExits = em.createQuery("SELECT o FROM Order o WHERE o.customer.name like :name", Order.class);
			orderExits.setParameter("name", "%" + valueSearch + "%");
		} else if (searchBy.equals(Param.ESTADO.toString())) {
			
			//TODO
			
		} else {
			try {
				SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
				Date dateSearch = formatoFecha.parse(valueSearch);
				orderExits = em.createQuery("Select o from Order o where o.createAt >= :dateSearch", Order.class);
				orderExits.setParameter("dateSearch", dateSearch);
			} catch (ParseException e) {
				orders = new ArrayList<>();
			}
		}
		orders = orderExits.getResultList();

		return orders;
	}

}