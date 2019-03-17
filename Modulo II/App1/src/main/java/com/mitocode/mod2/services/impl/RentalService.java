/**
 * 
 */
package com.mitocode.mod2.services.impl;

import com.mitocode.mod2.entities.CarRental;
import com.mitocode.mod2.entities.Invoice;
import com.mitocode.mod2.service.TaxService;

/**
 * @author Usuario
 *
 */
public class RentalService {

	private double pricePerDay;
	private double pricePerHour;
	
	private TaxService taxService;
//	private PeruTaxService taxService1;

	public RentalService(double pricePerDay, double pricePerHour, TaxService taxService) {
		super();
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRental carRental) {
		long t1 = carRental.getStart().getTime();
		long t2 = carRental.getStart().getTime();
		double hours = (double)(t2 - t1) /1000 /60 /60;
		
		double basicPayment;
		if (hours <= 12) {
			basicPayment = pricePerHour * Math.ceil(hours);
		}else {
			basicPayment = pricePerHour * Math.ceil(hours / 24);
		}
		
		double tax = taxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}
}
