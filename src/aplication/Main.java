package aplication;

import classes.Library;

public class Main {
	public static void main(String[] args) {
		Library myLibrary = new Library();
		Menu menu = new Menu();
		
		LoadDB.loadCollectionUserLends(myLibrary); // Método estático usado para simular carga de BD

		menu.showMenu(myLibrary);
		
	}
}
