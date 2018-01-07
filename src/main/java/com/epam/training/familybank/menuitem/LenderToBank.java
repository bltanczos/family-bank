package com.epam.training.familybank.menuitem;

import java.math.BigDecimal;

import com.epam.training.familybank.service.ClientService;

public class LenderToBank implements MenuItem {

	private final ClientService clientService;
	private final String currentUser;
	
	public LenderToBank(ClientService clientService, String currentUser) {
		this.clientService = clientService;
		this.currentUser = currentUser;
	}
	
	@Override
	public void run() {
		System.out.println("\n" + this + "\n");
		System.out.println("Amount: ");
		BigDecimal amount = new BigDecimal(System.console().readLine());

		clientService.sendFromClientToBank(currentUser, amount);
		
//		BankTransfer bankTransfer = new BankTransfer();
//		bankTransfer.setAmount(amount);
//		bankTransfer.setAccount();
		
		System.out.println("Amount has been lended!");
		System.console().readLine();
	}
	
	@Override
	public String toString() {
		return "Lend money to bank";
	}

}
