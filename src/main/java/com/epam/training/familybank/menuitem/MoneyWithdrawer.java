package com.epam.training.familybank.menuitem;

import java.math.BigDecimal;

import com.epam.training.familybank.service.ClientService;

public class MoneyWithdrawer implements MenuItem {

	private final ClientService clientService;
	private final String currentUser;

	public MoneyWithdrawer(ClientService clientService, String currentUser) {
		this.clientService = clientService;
		this.currentUser = currentUser;
	}

	@Override
	public void run() {
		System.out.println("\n" + this + "\n");
		System.out.println("Amount: ");
		BigDecimal amount = new BigDecimal(System.console().readLine());
		try {
			clientService.withdrawMoneyFromAccount(currentUser, amount);
			System.out.println("Money has been withdrawn!");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		System.console().readLine();
	}

	@Override
	public String toString() {
		return "Withdraw money from account";
	}

}
