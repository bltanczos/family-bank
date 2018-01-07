package com.epam.training.familybank;

import java.util.Map;

import com.epam.training.familybank.domain.User;
import com.epam.training.familybank.menuitem.MenuItem;
import com.epam.training.familybank.service.UserLoginService;

public abstract class UserMenu {

	protected final UserLoginService userLoginService;
	protected Map<Integer, MenuItem> menuMap;

	public UserMenu(UserLoginService userLoginService) {
		this.userLoginService = userLoginService;
	}

	public abstract void init();

	public void run() {
		int menuNumber = -1;
		while (menuNumber != 0) {
			display();
			try {
				menuNumber = Integer.parseInt(System.console().readLine());
				MenuItem menuItem = menuMap.get(menuNumber);
				if (menuItem != null) {
					clearScreen();
					menuItem.run();
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input! Press Enter to continue!");
			}
		}
		clearScreen();
	}

	protected void display() {
		clearScreen();
		User user = userLoginService.getUserInfo();
		System.out.println("Hello " + user.getFirstName() + " " + user.getLastName() + "!");

		for (Map.Entry<Integer, MenuItem> entry : menuMap.entrySet()) {
			System.out.println(entry.getKey() + ") " + entry.getValue());
		}
		System.out.println("0) Exit");
		System.out.println("Choose by number from the options above: ");
	}

	protected void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}
