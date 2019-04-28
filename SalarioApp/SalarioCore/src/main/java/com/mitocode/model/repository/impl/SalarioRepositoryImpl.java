package com.mitocode.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.mitocode.model.entity.Salario;
import com.mitocode.model.repository.SalarioRepository;

@Named
public class SalarioRepositoryImpl implements SalarioRepository, Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="visorPU")
	private EntityManager em;

	@Override
	public Integer insert(Salario t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer update(Salario t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer delete(Salario t) throws Exception {
		em.remove(t);
		return t.getId();
	}

	@Override
	public List<Salario> list() throws Exception {
		List<Salario> salarios = new ArrayList<Salario>();
		
		TypedQuery<Salario> query = em.createQuery("SELECT s FROM Salario s", Salario.class);
		salarios = query.getResultList();
		
		return salarios;
	}

	@Override
	public Salario findById(Salario t) throws Exception {
		List<Salario> salarios = new ArrayList<Salario>();
		TypedQuery<Salario> query = em.createQuery("SELECT s FROM Salario s WHERE s.id = ?1", Salario.class);
		query.setParameter(1, t.getId());
		
		salarios = query.getResultList();
		
		return salarios!=null && !salarios.isEmpty() ? salarios.get(0) : new Salario();
	}

}
