package com.epam.training.familybank.menuitem;

import java.math.BigDecimal;

import com.epam.training.familybank.service.AdministratorService;

public class CashPaymentToAccount implements MenuItem {

	private final AdministratorService administratorService;

	public CashPaymentToAccount(AdministratorService administratorService) {
		this.administratorService = administratorService;
	}

	@Override
	public void run() {
		System.out.println("\n" + this + "\n");
		System.out.println("Username: ");
		String userName = System.console().readLine();
		System.out.println("Amount: ");
		BigDecimal payment = new BigDecimal(System.console().readLine());
		try {
			administratorService.sendPaymentToAccount(userName, payment);
			System.out.println("\nPayment has been sent to the account");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		System.console().readLine();
	}

	@Override
	public String toString() {
		return "Pay cash to account";
	}

}
