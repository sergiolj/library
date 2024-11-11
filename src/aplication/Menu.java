package aplication;

import java.util.Scanner;

import classes.Library;
import classes.User;

public class Menu {
	public static Scanner sc = new Scanner(System.in);
	public static boolean finish = false;
	public static int option=0;
	public User user = new User();
	
	public void showMenu(Library library) {
		while(!finish) {
			System.out.println("Main Menu");
			System.out.println("[0] - Exit\n"
					+ "[1] - Insert new User\n"
					+ "[2] - Insert new Item\n"
					+ "[3] - List Collection Items\n"
					+ "[4] - List Users\n"
					+ "[5] - Lend Item\n"
					+ "[6] - Return Item\n");
			option=sc.nextInt();
			sc.nextLine();
			
			switch(option) {
			case 0:
				finish=true;
				break;
			case 1:
				user.createUser(sc, user);
				library.registerUser(user);
				break;
			case 2:
				library.addCollectionItem(null);
				break;
			case 3:
				library.listCollection();
				break;	
			case 4:
				library.listUser();
				break;	
			case 5:
				library.lendItem(null, null);
				break;	
			case 6:
				library.returnItem(null, null);
				break;	
			}
		}
	}
	
	

}