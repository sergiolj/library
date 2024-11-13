package application;

import classes.Library;

public class Main {
	public static void main(String[] args) {
		Library myLibrary = new Library(); // Criação do objeto biblioteca e suas listas e métodos		
		
		LoadDB.loadCollectionUserLends(myLibrary); // Método estático usado para simular carga de BD
		
		Menu menu = new Menu();
		menu.showMenu(myLibrary);
		
	}
}
