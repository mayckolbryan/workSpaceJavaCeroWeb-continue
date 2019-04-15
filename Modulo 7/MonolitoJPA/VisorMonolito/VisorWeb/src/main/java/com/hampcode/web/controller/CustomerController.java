package com.hampcode.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;


import com.hampcode.business.CustomerBusiness;
import com.hampcode.model.entity.Customer;
import com.hampcode.util.Message;

@Named
@ViewScoped
public class CustomerController implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Inject
	private CustomerBusiness customerBusiness;

	private Customer customer;
	private Customer customerSele;

	private List<Customer> customers;

	

	@PostConstruct
	public void init() {
		customer = new Customer();
		customerSele = new Customer();
		customers = new ArrayList<>();

		this.listCustomers();
	}

	public void listCustomers() {
		try {
			customers = customerBusiness.findAll();
		} catch (Exception e) {
			Message.messageError("Error Customer :" + e.getMessage());
		}
	}

	public void findCustomer() {
		try {
			this.customers = customerBusiness.findCustomerByName(this.customer.getName());
			if (customers.isEmpty()) {
				Message.messageInfo("No existe cliente");
			}
		} catch (Exception e) {
			Message.messageError("Error Customer :" + e.getMessage());
		}
	}

	public void saveCustomer() {
		try {

			if (customer.getId() != 0) {
				customerBusiness.update(customer);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {

				customerBusiness.insert(customer);
				Message.messageInfo("Registro guardado exitosamente");

			}
			listCustomers();
			resetForm();
		} catch (Exception e) {
			Message.messageError("Error Customer :" + e.getMessage());
		}
	}

	public void editCustomer() {
		try {
			System.out.println("Customer Selec:" + customerSele.getName());
			if (this.customerSele.getId() > 0) {
				this.customer = customerSele;
			} else {
				Message.messageInfo("Debe seleccionar un cliente");
				System.out.println("Hola:");
			}

		} catch (Exception e) {
			Message.messageError("Error Cliente :" + e.getMessage());
		}

	}

	public void resetForm() {
		this.customer = new Customer();
		this.customerSele = null;
	}

	public void selecCustomer(SelectEvent e) {
		this.customerSele = (Customer) e.getObject();
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomerSele() {
		return customerSele;
	}

	public void setCustomerSele(Customer customerSele) {
		this.customerSele = customerSele;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

}