package com.mitocode.mod1.application;

import com.mitocode.mod1.entities.BusinessAccount;

public class Program {

	public static void main(String[] args) {

		BusinessAccount account = new BusinessAccount(8010, "Bob Brown", 30.0, 500.0);

		System.out.println(account.getBalance());

	}

}
