package com.mitocode.business.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.mitocode.business.SalarioBusiness;
import com.mitocode.model.entity.Salario;
import com.mitocode.model.repository.SalarioRepository;

@Named
public class SalarioBusinessImpl implements SalarioBusiness, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private SalarioRepository salarioRepository;

	@Override
	@Transactional
	public Integer insert(Salario t) throws Exception {
		double sueldo = 0;
		int horasExtra = 0;
		if (t.getHora() <= 40) {
			sueldo = t.getHora() * 45;
		}else {
			horasExtra = t.getHora() - 40;
			sueldo = 40*45 + horasExtra*20;
		}
		t.setSueldo(sueldo);
		return salarioRepository.insert(t);
	}

	@Override
	@Transactional
	public Integer update(Salario t) throws Exception {
		double sueldo = 0;
		int horasExtra = 0;
		if (t.getHora() <= 40) {
			sueldo = t.getHora() * 45;
		}else {
			horasExtra = t.getHora() - 40;
			sueldo = 40*45 + horasExtra*20;
		}
		t.setSueldo(sueldo);
		return salarioRepository.update(t);
	}

	@Override
	@Transactional
	public Integer delete(Salario t) throws Exception {
		return salarioRepository.delete(t);
	}

	@Override
	public List<Salario> list() throws Exception {
		return salarioRepository.list();
	}

	@Override
	public Salario findById(Salario t) throws Exception {
		return salarioRepository.findById(t);
	}

}
