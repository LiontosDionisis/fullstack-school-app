package gr.aueb.cf.viewcontroller;

import java.awt.*;
import gr.aueb.cf.viewcontroller.*;



public class Main {
	private static Menu menu = new Menu();
	private static UsersMenu usersMenu = new UsersMenu();
	private static UserSearchResults userSearchResults = new UserSearchResults();
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu.setVisible(true);
					usersMenu.setVisible(false);
					userSearchResults.setVisible(false);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static Menu getMenu() {
		return menu;
	}
	public static UsersMenu getUsersMenu() {
		return usersMenu;
	}
	
	public static UserSearchResults getUserSearchResults() {
		return userSearchResults;
	}
}
