package com.mitocode.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.mitocode.business.SalarioBusiness;
import com.mitocode.model.entity.Salario;
import com.mitocode.util.Message;

@Named
@ViewScoped
public class SalarioController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private SalarioBusiness salarioBusiness;

	private Salario salario;
	private Salario salarioSelec;
	private List<Salario> salarios;

	@PostConstruct
	public void init() {
		salario = new Salario();
		salarioSelec = new Salario();
		loadSalario();
	}
	
	public void loadSalario() {
		try {
			this.salarios = salarioBusiness.list();
		} catch (Exception e) {
			Message.messageError("Error Salario :" + e.getMessage());
		}
	}
	
	public void saveSalario() {
		try {
			if (salario.getId() != null) {

				Message.messageInfo("Registro actualizado exitosamente");
				salarioBusiness.update(salario);
			} else {
				salarioBusiness.insert(salario);
				Message.messageInfo("Registro guardado exitosamente");

			}
			loadSalario();
			clearForm();
		} catch (Exception e) {
			Message.messageError("Error Category :" + e.getStackTrace());
		}
	}
	
	public void editSalario() {
		try {
			if (this.salarioSelec != null) {
				this.salario = salarioSelec;
			} else {
				Message.messageInfo("Debe seleccionar un registro");
			}
		} catch (Exception e) {
			Message.messageError("Error Salario :" + e.getMessage());
		}

	}
	
	public void clearForm() {
		this.salario = new Salario();
	}

	public void selectSalario(SelectEvent e) {
		this.salarioSelec = (Salario) e.getObject();
	}

	public Salario getSalario() {
		return salario;
	}

	public void setSalario(Salario salario) {
		this.salario = salario;
	}

	public Salario getSalarioSelec() {
		return salarioSelec;
	}

	public void setSalarioSelec(Salario salarioSelec) {
		this.salarioSelec = salarioSelec;
	}

	public List<Salario> getSalarios() {
		return salarios;
	}

	public void setSalarios(List<Salario> salarios) {
		this.salarios = salarios;
	}
}
