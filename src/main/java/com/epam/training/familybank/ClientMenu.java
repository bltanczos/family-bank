package com.epam.training.familybank;

import java.util.TreeMap;

import com.epam.training.familybank.menuitem.BalanceDisplayer;
import com.epam.training.familybank.menuitem.BorrowerFromBank;
import com.epam.training.familybank.menuitem.GiftSender;
import com.epam.training.familybank.menuitem.LenderToBank;
import com.epam.training.familybank.menuitem.MoneyWithdrawer;
import com.epam.training.familybank.service.ClientService;
import com.epam.training.familybank.service.UserLoginService;

public class ClientMenu extends UserMenu {

	private final ClientService clientService;
	private final String currentUser;

	public ClientMenu(UserLoginService userLoginService, ClientService clientService) {
		super(userLoginService);
		this.clientService = clientService;
		currentUser = userLoginService.getUserName();
	}

	@Override
	public void init() {
		menuMap = new TreeMap<>();
		menuMap.put(1, new BalanceDisplayer(clientService, currentUser));
		menuMap.put(2, new GiftSender(clientService, currentUser));
		menuMap.put(3, new MoneyWithdrawer(clientService, currentUser));
		menuMap.put(4, new LenderToBank(clientService, currentUser));
		menuMap.put(5, new BorrowerFromBank(clientService, currentUser));
	}
}
