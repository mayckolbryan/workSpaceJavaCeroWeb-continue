/**
 * 
 */
package com.mitocode.mod2.services.impl;

import com.mitocode.mod2.service.TaxService;

/**
 * @author Usuario
 *
 */
public class PeruTaxService implements TaxService{

	@Override
	public double tax(double amount) {
		if (amount <= 150.0) {
			return amount * 0.4;
		}else {
			return amount * 0.3;
		}
	}
}