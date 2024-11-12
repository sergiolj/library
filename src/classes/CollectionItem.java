package classes;

import java.util.Scanner;

public abstract class  CollectionItem implements LendRules {
	private static int idCounter=1;
	private int idItem;
	private String title;
	private String author;
	private int pageNumbers;

	private int publicationYear;
	private boolean available;	
	
	//Construtor
	public CollectionItem() {
		this.idItem = idCounter++;
		this.available = true;
	}
	
	public CollectionItem(String title, String author, int pageNumbers, int publicationYear) {
		this.idItem = idCounter++; 
		this.title = title;
		this.author = author;
		this.pageNumbers = pageNumbers;
		this.publicationYear = publicationYear;
		this.available = true;
	}
	
	//Getters and Setters
	
	
	public String getTitle() {
		return title;
	}
	
	public int getIdItem() {
		return idItem;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	

	public int getPageNumbers() {
		return pageNumbers;
	}

	public void setPageNumbers(int pageNumbers) {
		this.pageNumbers = pageNumbers;
	}

	public int getPublicationYear() {
		return publicationYear;
	}
	
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	//Methods
	public String availableStatus() {
		if(this.available) {
			return "Avaiable";
		}else {
			return "NOT Avaiable";
		}
	}


	
	/**
	 * Método implementado em função da Interface LendRules para que
	 * as subclasses de CollectionItem implementem seus prazos máximos de empréstimos
	 */
	@Override
	public int lendPeriod(){
		return 10;
	}

	public abstract CollectionItem createCollectionItem(Scanner sc);
	
}
