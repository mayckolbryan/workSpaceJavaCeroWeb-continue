package com.hampcode.business;

import java.util.List;
import java.util.Optional;

import com.hampcode.model.entity.Customer;

public interface CustomerBusiness extends CrudBusiness<Customer> {
	List<Customer> findCustomerByName(String name) throws Exception ;
	
	Optional<Customer> findCustomerByDni(String dni)throws Exception ;

}
