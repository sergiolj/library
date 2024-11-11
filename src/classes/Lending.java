package classes;

import java.time.LocalDate;

public class Lending {
	private User user;
	private CollectionItem collectionItem;
	private LocalDate lendDate;
	
	//Tempo de emprestimo é de 15 dias
	private int lendPeriod = 15;
	private LocalDate returnDate;
	
	public Lending(User user, CollectionItem collectionItem) {
		this.user = user;
		this.collectionItem = collectionItem;
		this.lendDate = LocalDate.now();
		this.returnDate = lendDate.plusDays(lendPeriod);
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public CollectionItem getCollectionItem() {
		return collectionItem;
	}
	public void setCollectionItem(CollectionItem collectionItem) {
		this.collectionItem = collectionItem;
	}
	public LocalDate getLendDate() {
		return lendDate;
	}
	
	public int getLendPeriod() {
		return lendPeriod;
	}
	public void setLendPeriod(int lendPeriod) {
		this.lendPeriod = lendPeriod;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	
	
	
	
}
