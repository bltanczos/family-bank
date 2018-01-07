package com.epam.training.familybank;

import java.util.TreeMap;

import com.epam.training.familybank.menuitem.CashPaymentToAccount;
import com.epam.training.familybank.menuitem.ClientAccountDisplayer;
import com.epam.training.familybank.menuitem.ClientCreationWithAccount;
import com.epam.training.familybank.menuitem.InterestPayment;
import com.epam.training.familybank.menuitem.InterestRateSetter;
import com.epam.training.familybank.service.AdministratorService;
import com.epam.training.familybank.service.UserLoginService;

public class AdministratorMenu extends UserMenu {

	private final AdministratorService administratorService;
	
	public AdministratorMenu(UserLoginService userLoginService, AdministratorService administratorService) {
		super(userLoginService);
		this.administratorService = administratorService;
	}

	@Override
	public void init() {
		menuMap = new TreeMap<>();
		menuMap.put(1, new ClientCreationWithAccount(administratorService));
		menuMap.put(2, new InterestPayment());
		menuMap.put(3, new ClientAccountDisplayer(administratorService));
		menuMap.put(4, new CashPaymentToAccount(administratorService));
		menuMap.put(5, new InterestRateSetter());
	}

}
