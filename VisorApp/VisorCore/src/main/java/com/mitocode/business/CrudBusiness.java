package com.mitocode.business;

import java.util.List;
import java.util.Optional;

public interface CrudBusiness<T> {

	T insert(T t) throws Exception;
	T update(T t) throws Exception;
	T delete(T t) throws Exception;
	Optional<T> find(T t) throws Exception;
	List<T> getAll() throws Exception;
}
