package com.hampcode.model.repository;

import java.util.Optional;

import com.hampcode.model.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer> {

	Optional<Customer> findByDni(String dni) throws Exception;
}