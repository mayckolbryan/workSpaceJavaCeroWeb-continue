package com.hampcode.service;


import java.util.Optional;

import com.hampcode.model.entity.Customer;

public interface ICustomerService extends CrudService<Customer> {

	Optional<Customer> findCustomerByDni(String dni) throws Exception;

}
