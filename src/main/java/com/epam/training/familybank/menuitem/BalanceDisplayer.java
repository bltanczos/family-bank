package com.epam.training.familybank.menuitem;

import java.math.BigDecimal;

import com.epam.training.familybank.service.ClientService;

public class BalanceDisplayer implements MenuItem {

	private final ClientService clientService;
	private final String currentUser;
	
	public BalanceDisplayer(ClientService clientService, String currentUser) {
		this.clientService = clientService;
		this.currentUser = currentUser;
	}
	
	@Override
	public void run() {
		BigDecimal balance = clientService.getBalanceByUsername(currentUser);
		System.out.println("\nYour balance: " + balance);
		System.console().readLine();
	}
	
	@Override
	public String toString() {
		return "Show my balance";
	}

}
