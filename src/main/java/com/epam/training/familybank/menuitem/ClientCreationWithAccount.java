package com.epam.training.familybank.menuitem;

import com.epam.training.familybank.service.AdministratorService;

public class ClientCreationWithAccount implements MenuItem {

	private final AdministratorService administratorService;

	public ClientCreationWithAccount(AdministratorService administratorService) {
		this.administratorService = administratorService;
	}

	@Override
	public void run() {
		System.out.println("\n" + this + "\n");
		System.out.println("Username: ");
		String userName = System.console().readLine();
		System.out.println("First name: ");
		String firstName = System.console().readLine();
		System.out.println("Last name: ");
		String lastName = System.console().readLine();
		System.out.println("Password: ");
		String password = String.valueOf(System.console().readPassword());

		administratorService.createClientWithAccount(userName, firstName, lastName, password);
		
		System.out.println("Client has been created!");
		System.console().readLine();
	}

	@Override
	public String toString() {
		return "Create client with account";
	}

	
}
