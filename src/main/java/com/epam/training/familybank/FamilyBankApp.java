package com.epam.training.familybank;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.epam.training.familybank.domain.RoleType;
import com.epam.training.familybank.domain.User;
import com.epam.training.familybank.service.AdministratorService;
import com.epam.training.familybank.service.BankInitService;
import com.epam.training.familybank.service.ClientService;
import com.epam.training.familybank.service.UserLoginService;
import com.epam.training.familybank.spring.SpringConfigurationDao;
import com.epam.training.familybank.spring.SpringConfigurationJpa;
import com.epam.training.familybank.spring.SpringConfigurationService;

public class FamilyBankApp {

	private final AbstractApplicationContext context;

	private final ClientService clientService;
	private final AdministratorService administratorService;
	private final UserLoginService userLoginService;
	private final BankInitService bankInitService;

	private UserMenu userMenu;

	public FamilyBankApp() {
		context = new AnnotationConfigApplicationContext(SpringConfigurationJpa.class, SpringConfigurationDao.class,
				SpringConfigurationService.class);
		bankInitService = context.getBean(BankInitService.class);
		userLoginService = context.getBean(UserLoginService.class);
		clientService = context.getBean(ClientService.class);
		administratorService = context.getBean(AdministratorService.class);
	}

	public static void main(String[] args) {
		FamilyBankApp familyBankApp = new FamilyBankApp();
		familyBankApp.run();
		System.exit(0);
	}

	public void run() {
		try {
			User admin = bankInitService.createAdminUser();
			bankInitService.createBankAccount(admin);
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
		boolean isLoginSuccessful = login();
		if (isLoginSuccessful) {
			setUserMenu();
			userMenu.init();
			userMenu.run();
		}
	}

	private boolean login() {
		clearScreen();
		System.out.println("\nLogin\n");
		System.out.print("User name: ");
		System.out.flush();
		String userName = System.console().readLine();

		System.out.print("Password: ");
		System.out.flush();
		String password = String.valueOf(System.console().readPassword());

		try {
			userLoginService.authenticateUser(userName, password);
		} catch (RuntimeException e) {
			// clearScreen();
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	private void setUserMenu() {
		User user = userLoginService.getUserInfo();
		if (user.getRole() == RoleType.CLIENT) {
			userMenu = new ClientMenu(userLoginService, clientService);
		}
		if (user.getRole() == RoleType.ADMINISTRATOR) {
			userMenu = new AdministratorMenu(userLoginService, administratorService);
		}

	}

	private void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}
