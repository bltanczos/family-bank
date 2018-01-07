package com.epam.training.familybank.menuitem;

import java.math.BigDecimal;

import com.epam.training.familybank.service.ClientService;

public class BorrowerFromBank implements MenuItem {

	private final ClientService clientService;
	private final String currentUser;

	public BorrowerFromBank(ClientService clientService, String currentUser) {
		this.clientService = clientService;
		this.currentUser = currentUser;
	}

	@Override
	public void run() {
		System.out.println("\n" + this + "\n");
		System.out.println("Amount: ");
		BigDecimal amount = new BigDecimal(System.console().readLine());

		try {
			clientService.sendFromBankToClient(currentUser, amount);
			System.out.println("Amount has been lended!");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

		// BankTransfer bankTransfer = new BankTransfer();
		// bankTransfer.setAmount(amount);
		// bankTransfer.setAccount();
		
		System.console().readLine();
	}

	@Override
	public String toString() {
		return "Borrow money from bank";
	}

}
