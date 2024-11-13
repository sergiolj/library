/**
 * @date 2024/november
 * @author Sérgio Lopes Junior
 * @email sergiolj@gmail.com
 */
package classes;

import java.time.LocalDate;

public class Lending {
	private User user;
	private CollectionItem collectionItem;
	private LocalDate lendDate;
	
	private LocalDate returnDate;
	
	//Constructor
	
	public Lending() {
		this.lendDate = LocalDate.now();
		this.returnDate = lendDate.plusDays(collectionItem.lendPeriod());
	}
	/**
	 * O Método construtor necessita de dois parâmetros passados pelo usuário para proceder
	 * com um empréstimo, basicamente qual o item a ser emprestado e quem é o usuário que fará
	 * o empréstimo. Os demais atributos da classe são automaticamente preenchidos, os quais são a data
	 * do empréstimo (data atual do sistema) e a data para retorno do item que é calculada com
	 * base no tipo de regra de empréstimo definida na Interface LendRules e implementada
	 * em livros e trabalhos acadêmicos.
	 * @param collectionItem
	 * @param user
	 */
	public Lending(CollectionItem collectionItem, User user) {
		this.user = user;
		this.collectionItem = collectionItem;
		this.lendDate = LocalDate.now();
		this.returnDate = lendDate.plusDays(collectionItem.lendPeriod());
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
	
	public LocalDate getReturnDate() {
		return returnDate;
	}
	
	
}
