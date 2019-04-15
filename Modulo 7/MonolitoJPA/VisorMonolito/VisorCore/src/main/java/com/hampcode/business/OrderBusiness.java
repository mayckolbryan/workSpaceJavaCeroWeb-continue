package com.hampcode.business;

import java.util.List;

import com.hampcode.model.entity.Order;

public interface OrderBusiness extends CrudBusiness<Order> {
	public List<Order> findOrder(String searchBy, String valueSearch) throws Exception;

}
