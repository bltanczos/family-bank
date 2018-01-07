package com.epam.training.familybank.menuitem;

import java.math.BigDecimal;

import com.epam.training.familybank.service.ClientService;

public class GiftSender implements MenuItem {

	private final ClientService clientService;
	private final String currentUser;

	public GiftSender(ClientService clientService, String currentUser) {
		this.clientService = clientService;
		this.currentUser = currentUser;
	}

	@Override
	public void run() {
		System.out.println("\n" + this + "\n");
		System.out.println("Receiver's username: ");
		String receiverUserName = System.console().readLine();
		System.out.println("Amount: ");
		BigDecimal amount = new BigDecimal(System.console().readLine());

		try {
			clientService.sendFromClientToClient(currentUser, receiverUserName, amount);
			System.out.println("Amount has been sent!");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		System.console().readLine();

	}

	@Override
	public String toString() {
		return "Sending gift";
	}

}
