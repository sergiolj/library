/**
 * @date 2024/november
 * @author Sérgio Lopes Junior
 * @email sergiolj@gmail.com
 */
package classes;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class  CollectionItem implements LendRules {
	private static int idCounter=1; // Contador de itens da classe CollectionItem que funciona como identificador para itens do acervo
	private int idItem;
	private String title;
	private String author;
	private int pageNumbers;

	private int publicationYear;
	private boolean available;	
	
	//Construtor
	public CollectionItem() {
		try {
			/**
			 * Construtor vazio usado para a criação de itens de acervo pelo usuário e 
			 * sujeito a erros de tipos de dados inválidos.
			 */		
		}catch(InputMismatchException e) {
			/**
			 * As mensagens de erro são tratadas pela subclasse
			 * através da implementação do método abstrato createCollectionItem(Scanner sc)
			 */
		}
		finally{
			this.idItem = idCounter++; // Só incrementa o contador caso o objeto seja instanciado corretamente
			this.available = true;
		}
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
		/**
		 * Aqui podem ser implementadas regras sobre como esse campo deve ser preenchido,
		 * possivelmente comprimento mínimo e máximo do atributo ou outras regras aplicáveis.
		 */
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		/**
		 * Aqui podem ser implementadas regras sobre como esse campo deve ser preenchido,
		 * possivelmente comprimento mínimo e máximo do atributo ou outras regras aplicáveis.
		 */
		this.author = author;
	}
	

	public int getPageNumbers() {
		return pageNumbers;
	}

	public void setPageNumbers(int pageNumbers) {
		/**
		 * Aqui podem ser implementadas regras sobre como esse campo deve ser preenchido,
		 * impedindo, por exemplo, a inserção de números negativos ou outras regras aplicáveis.
		 */
		this.pageNumbers = pageNumbers;
	}

	public int getPublicationYear() {
		return publicationYear;
	}
	
	public void setPublicationYear(int publicationYear) {
		/**
		 * Aqui podem ser implementadas regras sobre como esse campo deve ser preenchido,
		 * impedindo, por exemplo, a inserção de números negativos, valores maiores do que a
		 * data atual ou outras regras aplicáveis.
		 */
		this.publicationYear = publicationYear;
	}
	
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	//Methods
	/**
	 * Método usado para ler o conteúdo de um parâmetro boleano que armazena a informação de que o item está ou não
	 * disponível para empréstimo.
	 * @return
	 */
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
