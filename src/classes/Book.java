package classes;

import java.util.Scanner;

public class Book extends CollectionItem {
	private int edition;
	private int editionYear;
	private String publisher;
	
	//Constructor
	public Book() {}
	
	public Book(String title, String author, int pageNumbers, int publicationYear, int edition, int editionYear,
			String publisher) {
		super(title, author, pageNumbers, publicationYear);
		this.edition = edition;
		this.editionYear = editionYear;
		this.publisher = publisher;
	}

	//Getters and Setters
	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public int getEditionYear() {
		return editionYear;
	}

	public void setEditionYear(int editionYear) {
		this.editionYear = editionYear;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}	
	
	//Methods

		@Override
		/**
		 * Livros comuns podem ter um prazo de emprétimo de 15 dias
		 */
		public int lendPeriod() {
			return 15;
		}
		@Override
		public static CollectionItem createCollectionItem(Scanner sc) {
			Book book3 = new Book("Endurance", "Alfred Lasing", 282, 1959,1, 1959,"MCGRAW HILL");
			return book3;
		}
}
