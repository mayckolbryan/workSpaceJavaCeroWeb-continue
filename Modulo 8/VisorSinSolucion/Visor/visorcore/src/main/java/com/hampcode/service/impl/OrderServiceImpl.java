package com.hampcode.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Order;
import com.hampcode.model.repository.IOrderRepository;
import com.hampcode.service.IOrderService;

@Named
public class OrderServiceImpl implements IOrderService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IOrderRepository orderRepository;

	@Transactional
	@Override
	public Integer insert(Order t) throws Exception {
		
		t.getItems().forEach(item -> item.setOrderId(t));

		return orderRepository.insert(t);
	}

	@Transactional
	@Override
	public Integer update(Order t) throws Exception {
		return null;
	}

	@Transactional
	@Override
	public Integer delete(Order t) throws Exception {
		return null;
	}

	@Override
	public List<Order> findAll() throws Exception {
		return orderRepository.findAll();
	}

	@Override
	public Order findById(Order t) throws Exception {
		return orderRepository.findById(t);
	}

}
