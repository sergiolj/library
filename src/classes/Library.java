package classes;

import java.util.ArrayList;

public class Library {
	private ArrayList<CollectionItem> collection;
	private ArrayList<User> user;
	private ArrayList<Lending> lending;
	
	//Constructor
	/**
	 * Inicializa o construtor sem a necessidade de que o usuário passe parâmetros
	 * já que os parâmetros necessários são as listas que irão armazenar os objetos
	 * das outras classes.
	 */
	public Library() {
		this.collection = new ArrayList<>();
		this.user = new ArrayList<>();
		this.lending = new ArrayList<>();
	}
	
	//Getters and Setters
	/**
	 * Não foi necessário utilizar nenhum getter and setter para a classe Library
	 */
	
	//Methods
	/**
	 * Método para adicionar um objeto collectionItem à lista de itens da biblioteca.
	 * @param collectionItem
	 */
	public void addCollectionItem(CollectionItem collectionItem) {
		this.collection.add(collectionItem);
	}
	
	/**
	 * Método para adicionar um objeto user à Lista de usuários.
	 * @param user
	 */
	public void registerUser(User user) {
		this.user.add(user);
	}
	
	
	
	public void createUser() {
		User newUser = new User();
		newUser.createUser();
		registerUser(newUser);
	}
	
	
	/**
	 * Método para empréstimo de item, passando como parâmatros os objetos collectionItem e User.
	 * O método verifica se o item está disponível para empréstimo, caso positivo instancia um empréstimo
	 * através do método Lending passando os parâmetros de usuário e item a ser emprestado.
	 * Após instanciar o ArrayList lendind recebe os dados do objeto emprestado (lend)
	 * A seguir modifica a variável que controla a disponibilidade do item para false e informa ao usuário
	 * a data limite para a devolução.
	 * Caso o item esteja indisponível informa ao usuário sua indisponibilidade.
	 * 
	 * @param collectionItem
	 * @param user
	 */
	public void lendItem(CollectionItem collectionItem, User user) {
		if(collectionItem.isAvailable()) {
			Lending lend = new Lending(collectionItem, user);
			this.lending.add(lend);
			collectionItem.setAvailable(false);
			System.out.println("\nEnjoy your reading!! You must return it until "+lend.getReturnDate());
			System.out.println();
		}else {
			System.out.print("\nSorry!! The item [" + collectionItem.getTitle() + "] isn't avaiable.\n");
			System.out.println();
		}
	}
	
	/**
	 * Método criado para devolver o item passando como parâmetros novamente o item da coleção e o nome do usuário
	 * Cria um objeto empréstimo passando os parâmetros collectionItem e user.
	 * Cria um booleano 'encontrado' inicializado como false para indicar, caso o item solicitado para retorno
	 * não seja encontrado.
	 * Usa um forEach para verificar l no vetor de empréstimo, caso o usuário do empréstimo e o item emprestado
	 * sejam equals ele remove o item l do vetor de emprestados, modifica o atributo de disponível para true
	 * e o boleano encontrado para true encerrando o forEach.
	 * Caso não haja correspondência exata entre os dois parâmetros o Not (!)found permanece como true
	 * e a mensagem de não encontrada é exibida.
	 * @param collectionItem
	 * @param user
	 */
	public void returnItem(CollectionItem collectionItem, User user) {
		Lending lend = new Lending(collectionItem, user);
		boolean found=false;
		for(Lending l:lending) {
			if((l.getUser().equals(lend.getUser())) && (l.getCollectionItem().equals(lend.getCollectionItem()))) {
				lending.remove(l);
				collectionItem.setAvailable(true);
				System.out.println("Thank you for using our services!\n");
				found=true;
				break;
			}
		}
		if(!found) {
			System.out.println("Item not found in database.");
		}
	}
	
	/**
	 * Método que exibe a lista de itens cadastrados na collection, que podem ser livros ou
	 * trabalhos acadêmicos, ou quais outros itens que sejam adicionados ao acervo e que
	 * sejam definidos como subclasse de CollectionItem
	 */
	public void listCollection() {
		System.out.print("Library Collection\n");
		System.out.println("``````````````````````");
		int index=0;
		for(CollectionItem i: collection) {
			index++;
			System.out.print(index+"|"+i.getTitle()+" | "+i.getAuthor()+ " | "+i.availableStatus()+"\n");
		}
		System.out.println();
	}
	
	/**
	 * Método exibe a lista de itens da coleção que estão atualmente emprestados ao iterar e imprimir
	 * o conteúdo da lista lending, caso o tamanho da lista seja maior do que 0.
	 * Se o tamanho for menor do que 1 quer dizer que não existem adições à lista e o retorno
	 * será "Não existem itens emprestados no momento"
	 */
	public void listLendedItems() {
		int index=0;
		if(lending.size()>0) {
			index++;
			for(Lending l: lending) {
				System.out.print(index+"|"+l.getCollectionItem().getTitle()+" | "+l.getUser().getName()+" | "+l.getReturnDate()+"\n");
			}
		}else {
			System.out.println("At the moment there is no lended items!");
		}

	}
	
	/**
	 * Método para listar os usuários armazenados na lista user.
	 * Através de um forEach iterrando o objeto User u através da lista user o resultado
	 * é impresso na tela com os atributos de nome do usuário, cpf e data de nascimento.
	 */
	public void listUser() {
		int index=0;
		System.out.print("User List\n");
		for(User u: user) {
			index++;
			System.out.print(index+"|"+u.getName()+" | "+u.getUserName()+" | "+u.getSocialSecurityNumber()+" | "+u.getDateOfBirth()+"\n");
		}
		System.out.println();
	}
}
