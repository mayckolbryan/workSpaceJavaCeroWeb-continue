package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;

import org.primefaces.event.SelectEvent;

import com.hampcode.service.ICustomerService;
import com.hampcode.service.IOrderService;
import com.hampcode.service.IProductService;
import com.hampcode.model.entity.Customer;
import com.hampcode.model.entity.DetailOrder;

import com.hampcode.model.entity.Order;
import com.hampcode.model.entity.Product;

import com.hampcode.util.Message;

@Named
@ViewScoped
public class OrderController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IOrderService orderService;

	@Inject
	private ICustomerService customerService;

	@Inject
	private IProductService productService;

	private Order order;
	private Order orderSel;
	private List<Order> orders;

	private DetailOrder detailOrder;
	private DetailOrder detailOrderSel;
	private List<DetailOrder> detailOrders;

	private Customer customer;

	private Product product;
	private List<Product> products;

	@PostConstruct
	public void init() {
		order = new Order();
		orderSel = new Order();
		orders = new ArrayList<>();

		detailOrder = new DetailOrder();
		detailOrderSel = new DetailOrder();
		detailOrders = new ArrayList<>();

		customer = new Customer();

		product = new Product();
		products = new ArrayList<>();

		this.loadProduct();

	}

	public void findCustomerByDni() {
		try {

			Optional<Customer> customerExist = customerService.findCustomerByDni(customer.getDni());

			if (customerExist.isPresent()) {
				customer = customerExist.get();
			}
		} catch (NoResultException e) {
			Message.messageInfo("Cliente no existe");
			resetForm();
		} catch (Exception e) {
			Message.messageError("Error Order :" + e.getMessage());
		}
	}

	public void addProductToDetail() {
		detailOrder.setProduct(product);
		
		detailOrders.add(detailOrder);
		
		cleanDetailOrder();
	}

	public void loadProduct() {
		try {
			this.products = productService.findAll();
		} catch (Exception e) {

		}
	}

	public List<Product> autoCompleteProduct(String query) {

		List<Product> productsFilter = new ArrayList<Product>();

		try {
			List<Product> products = productService.findAll();
			for (int i = 0; i < products.size(); i++) {
				Product product = products.get(i);

				if (product.getName().startsWith(query)) {
					productsFilter.add(product);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return productsFilter;
	}

	public void updatePriceProduct() {
		this.detailOrder.setPrice(product.getPrice());
	}

	public void calculateAmountDetail() {
		double amount;
		amount = this.detailOrder.getPrice() * this.detailOrder.getQuantity();
		this.detailOrder.setAmount(amount);
	}

	public void saveOrder() {
		try {
			if (customer != null) {
				if (!detailOrders.isEmpty()) {

					order.setCustomer(customer);
					order.setItems(detailOrders);

					orderService.insert(order);

					resetForm();
					cleanDetailOrder();

					Message.messageInfo("Registro de orden");
				} else {
					Message.messageInfo("La orden no tiene detalle");
				}
			} else {
				Message.messageInfo("Debe buscar un cliente");
			}

		} catch (Exception e) {
			Message.messageError("Error Order :" + e.getMessage());
		}
	}

	public void cleanDetailOrder() {
		this.detailOrder = new DetailOrder();
		this.product = new Product();
	}

	public void resetForm() {
		this.order = new Order();
		this.orderSel = null;
		this.detailOrders.clear();
		this.customer = new Customer();
	}

	public void selectOrder(SelectEvent ev) {
		this.orderSel = (Order) ev.getObject();
	}

	public void selectDetailOrder(SelectEvent ev) {
		this.detailOrder = (DetailOrder) ev.getObject();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Order getOrderSel() {
		return orderSel;
	}

	public void setOrderSel(Order orderSel) {
		this.orderSel = orderSel;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public DetailOrder getDetailOrder() {
		return detailOrder;
	}

	public void setDetailOrder(DetailOrder detailOrder) {
		this.detailOrder = detailOrder;
	}

	public DetailOrder getDetailOrderSel() {
		return detailOrderSel;
	}

	public void setDetailOrderSel(DetailOrder detailOrderSel) {
		this.detailOrderSel = detailOrderSel;
	}

	public List<DetailOrder> getDetailOrders() {
		return detailOrders;
	}

	public void setDetailOrders(List<DetailOrder> detailOrders) {
		this.detailOrders = detailOrders;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
