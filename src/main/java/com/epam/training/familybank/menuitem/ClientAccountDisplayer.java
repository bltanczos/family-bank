package com.epam.training.familybank.menuitem;

import com.epam.training.familybank.domain.Account;
import com.epam.training.familybank.service.AdministratorService;

public class ClientAccountDisplayer implements MenuItem {

	private final AdministratorService administratorService;

	public ClientAccountDisplayer(AdministratorService administratorService) {
		this.administratorService = administratorService;
	}

	@Override
	public void run() {
		System.out.println("\n" + this + "\n");
		System.out.println("Username: ");
		String userName = System.console().readLine();

		try {
			Account account = administratorService.getAccountByUsername(userName);
			System.out.println("\nAccount ID: " + account.getId());
			System.out.println("Balance: " + account.getBalance());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		System.console().readLine();
	}

	@Override
	public String toString() {
		return "Show user's account";
	}

}
