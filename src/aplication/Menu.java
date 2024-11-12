package aplication;

import java.util.InputMismatchException;
import java.util.Scanner;

import classes.AcademicWork;
import classes.Book;
import classes.CollectionItem;
import classes.Library;
import classes.User;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private boolean toChoose = false;
	private int option;
	private int idUser = 0;
	private int idItem = 0;
	private CollectionItem collectionItem = null;
	
	public void showMenu(Library library) {
		option = -1;
		while(!toChoose) {
				System.out.println("Main Menu");
				System.out.println("[0] - Exit\n"
						+ "[1] - Insert new User\n"
						+ "[2] - Insert new Item\n"
						+ "[3] - List Collection Items\n"
						+ "[4] - List Users\n"
						+ "[5] - List Lend Items\n"
						+ "[6] - Lend Item\n"
						+ "[7] - Return Item\n");
				
			try{
				option=sc.nextInt();
				sc.nextLine();

				if(option>=0 && option<=7) {
					switch(option) {
					case 0:
						toChoose=true;
						break;
					case 1:
						library.registerUser(User.createUser(sc));
						break;
					case 2:
						collectionItem = chooseType();
						try {
							library.addCollectionItem(collectionItem.createCollectionItem(sc));
						}catch(NullPointerException e) {
							collectionItem = chooseType();
						}
						break;
					case 3:
						library.listCollection();
						break;	
					case 4:
						library.listUsers();
						break;
					case 5:
						library.listLendedItems();
						break;	
					case 6:
						setidItemidUser();
						library.lendItem(this.idItem, this.idUser);
						break;	
					case 7:
						setidItemidUser();
						library.returnItem(this.idItem, this.idUser);
						break;	
					}
				}else {
					System.out.println("Invalid option. Choose any option between 0-7\n");
				}
			}catch (InputMismatchException e) {
				System.out.println("Invalid option. Only numbers are accepted.\n");
				sc.nextLine(); // Cleaning buffer to avoid ifinite loop behavior
			}	
		}

	}

	private void setidItemidUser() {
		System.out.println("Set idUser");
		this.idUser = sc.nextInt();
		System.out.println("Set Collection Item");
		this.idItem = sc.nextInt();
	}

	private CollectionItem chooseType() {
		option = -1;
		boolean toChoose =  false;

		while(!toChoose) {

				System.out.println("Main Menu");
				System.out.println("[0] - Exit\n"
						+ "[1] - Insert new Book\n"
						+ "[2] - Insert new Academic Work\n");
			try {
				option=sc.nextInt();
				sc.nextLine();

				if(option>=0 && option<=2) {
					switch(option) {
					case 0:
						toChoose=true;
						break;
					case 1:
						Book book = new Book();
						collectionItem = book;
						toChoose=true;
						return collectionItem;
					case 2:
						AcademicWork academicWork = new AcademicWork();
						collectionItem = academicWork;
						toChoose=true;
						return collectionItem;

					default:
						System.out.println("Invalid option. Try again.\n");
						break;
					}
				}else {
					System.out.println("Invalid option. Choose any option between 0-2\n");
				}
			}catch (InputMismatchException e) {
				System.out.println("Invalid option. Only numbers are accepted.\n");
				sc.nextLine(); // Cleaning buffer to avoid ifinite loop behavior
			}
		}
		return collectionItem;
	}
}