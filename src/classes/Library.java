package classes;

import java.util.ArrayList;

public class Library {
	private ArrayList<CollectionItem> collection = new ArrayList<>();
	private ArrayList<User> user = new ArrayList<>();
	private ArrayList<Lending> lending = new ArrayList<>();
	
	//Constructor
	public Library() {}
	
	public ArrayList<CollectionItem> getCollection() {
		return collection;
	}

	public ArrayList<User> getUser() {
		return user;
	}
	public void setUser(ArrayList<User> user) {
		this.user = user;
	}
	
	
	public ArrayList<Lending> getBorrowing() {
		return lending;
	}

	//Methods
	public void addCollectionItem(CollectionItem collectionItem) {
		this.collection.add(collectionItem);
	}
	
	public void listCollection() {
		System.out.print("Library Collection\n");
		for(CollectionItem i: collection) {
			System.out.print(i.getTitle()+" | "+i.getAuthor()+ " | "+i.availableStatus()+"\n");
		}
		System.out.println();
	}
	
	public void registerUser(User user) {
		this.user.add(user);
	}
	
	public void listUser() {
		System.out.print("User List\n");
		for(User u: user) {
			System.out.print(u.getName()+" | "+u.getSocialSecurityNumber()+" | "+u.getDateOfBirth()+"\n");
		}
		System.out.println();
	}
	
	/*
	 * Methods
	 * Método para empréstimo de item, passando como parâmatros os objetos collectionItem e User.
	 * O método verifica se o item está disponível para empréstimo, caso positivo instancia um empréstimo
	 * através do método Lending passando os parâmetros de usuário e item a ser emprestado.
	 * A seguir modifica a variável que controla a disponibilidade do item para false e informa ao usuário
	 * a data limite para a devolução.
	 * Caso o item esteja indisponível informa o usuário.
	 * 
	 */
	public void lendItem(CollectionItem collectionItem, User user) {
		if(collectionItem.isAvailable()) {
			Lending lend = new Lending(user, collectionItem);
			this.lending.add(lend);
			collectionItem.setAvailable(false);
			System.out.println("\nEnjoy your reading!! You must return it until "+lend.getReturnDate());
			System.out.println();
		}else {
			System.out.print("\nSorry!! The item [" + collectionItem.getTitle() + "] isn't avaiable.\n");
			System.out.println();
		}
	}
	
	public void returnItem(CollectionItem collectionItem, User user) {
		Lending lend = new Lending(user, collectionItem);
		
		this.lending.remove(lend);
		collectionItem.setAvailable(true);
	}
	
	public void listLendedItems() {
		for(Lending l: lending) {
			System.out.print(l.getCollectionItem().getTitle()+" | "+l.getUser().getName()+" | "+l.getReturnDate()+"\n");
		}
	}
}
