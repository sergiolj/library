package aplication;

import classes.Library;

public class Main {
	public static void main(String[] args) {
		Library myLibrary = new Library();
		Menu menu = new Menu();
		
		LoadDB.loadCollectionItems(myLibrary);
		LoadDB.loadSubscribedUsers(myLibrary);
		
		menu.showMenu(myLibrary);
		
	}
}
