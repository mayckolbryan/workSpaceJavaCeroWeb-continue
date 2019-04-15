package com.hampcode.business.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.business.UserBusiness;
import com.hampcode.model.entity.User;
import com.hampcode.model.repository.UserRepository;

@Named
public class UserBusinessImpl implements UserBusiness, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UserRepository userRepository;

	@Transactional
	@Override
	public Integer insert(User t) throws Exception {
		return userRepository.insert(t);
	}

	@Transactional
	@Override
	public Integer update(User t) throws Exception {
		return userRepository.update(t);
	}

	@Transactional
	@Override
	public Integer delete(User t) throws Exception {
		return userRepository.delete(t);
	}

	@Override
	public List<User> findAll() throws Exception {
		return userRepository.findAll();
	}

	@Override
	public User findById(User t) throws Exception {
		return userRepository.findById(t);
	}

	@Override
	public Optional<User> authentication(User user) throws Exception {
		return null;
	}

}
