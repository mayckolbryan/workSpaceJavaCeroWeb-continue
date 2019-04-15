package com.hampcode.model.repository;

import java.util.List;

import com.hampcode.model.entity.Order;

public interface OrderRepository extends JpaRepository<Order> {
	
	public List<Order> findOrder(String searchBy,String valueSearch) throws Exception;

}