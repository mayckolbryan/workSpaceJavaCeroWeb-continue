/**
 * 
 */
package com.mitocode.mod2.services.impl;

import com.mitocode.mod2.service.TaxService;

/**
 * @author Usuario
 *
 */
public class BrazilTaxService implements TaxService{

	@Override
	public double tax(double amount) {
		if (amount <= 100.0) {
			return amount * 0.2;
		}else {
			return amount * 0.15;
		}
	}
}
