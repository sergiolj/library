package aplication;

import classes.Library;

public class Main {
	public static void main(String[] args) {
		Library myLibrary = new Library();
		
		LoadDB.loadCollectionItems(myLibrary);
		LoadDB.loadSubscribedUsers(myLibrary);

		Menu.showMenu(myLibrary);
		
	}
}
