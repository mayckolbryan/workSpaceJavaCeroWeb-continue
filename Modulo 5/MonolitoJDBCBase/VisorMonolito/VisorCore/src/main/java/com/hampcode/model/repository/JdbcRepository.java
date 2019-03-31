package com.hampcode.model.repository;

import java.util.List;
import java.util.Optional;

public interface JdbcRepository<T> {

	T insert(T t) throws Exception;

	T update(T t) throws Exception;

	T delete(T t) throws Exception;

	Optional<T> find(T t) throws Exception;

	List<T> findAll() throws Exception;
}
