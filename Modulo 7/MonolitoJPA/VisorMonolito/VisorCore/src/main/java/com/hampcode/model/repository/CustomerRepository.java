package com.hampcode.model.repository;

import java.util.List;
import java.util.Optional;

import com.hampcode.model.entity.Customer;



public interface CustomerRepository extends JpaRepository<Customer> {

	List<Customer> findByName(String name) throws Exception;

	Optional<Customer> findByDni(String dni) throws Exception;
}