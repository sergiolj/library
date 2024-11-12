package aplication;

import classes.*;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Library myLibrary = new Library();
		
		LoadDB.loadCollectionItems(myLibrary);
		LoadDB.loadSubscribedUsers(myLibrary);
		
		
		Book book = new Book();
		Book book1 = new Book();
		
		User user = new User();
		
		System.out.println(book.getIdItem());
		System.out.println(book1.getIdItem());
		
		System.out.println(user.getIdUser());
	}

}
