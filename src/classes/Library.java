/**
 * @date 2024/november
 * @author Sérgio Lopes Junior
 * @email sergiolj@gmail.com
 */
package classes;

import java.util.ArrayList;

public class Library {
	private ArrayList<CollectionItem> collectionList;
	private ArrayList<User> userList;
	private ArrayList<Lending> lendingList;
	
	//Constructor
	/**
	 * Inicializa o construtor sem a necessidade de que o usuário passe parâmetros
	 * já que os parâmetros necessários são as listas que irão armazenar os objetos
	 * das outras classes.
	 */
	public Library() {
		this.collectionList = new ArrayList<>();
		this.userList = new ArrayList<>();
		this.lendingList = new ArrayList<>();
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
		this.collectionList.add(collectionItem);
	}
	
	/**
	 * Método para adicionar um objeto user à Lista de usuários.
	 * @param user
	 */
	public void registerUser(User user) {
		this.userList.add(user);
	}
	
	/**
	 * Método para empréstimo de item, passando como parâmatros os objetos collectionItem e User.
	 * O método verifica se o item está disponível para empréstimo, caso positivo instancia um empréstimo
	 * através do método Lending passando os parâmetros de usuário e item a ser emprestado.
	 * Após instanciar o ArrayList lendindList recebe os dados do objeto emprestado (lend)
	 * A seguir modifica a variável que controla a disponibilidade do item para false e informa ao usuário
	 * a data limite para a devolução.
	 * Caso o item esteja indisponível informa ao usuário sua indisponibilidade.
	 * 
	 * Aqui temos dois métodos com nomes iguais mas parâmetros diferentes, os chamados MÉTODOS SOBRECARREGADOS.
	 * 
	 * @param collectionItem
	 * @param user
	 */
	public void lendItem(CollectionItem collectionItem, User user) {
		if(collectionItem.isAvailable()) {
			Lending lend = new Lending(collectionItem, user);
			this.lendingList.add(lend);
			collectionItem.setAvailable(false);
			System.out.println("\nEnjoy your reading!! You must return it until "+lend.getReturnDate());
			System.out.println();
		}else {
			System.out.print("\nSorry!! The item [" + collectionItem.getTitle() + "] isn't avaiable.\n");
			System.out.println();
		}
	}
	
	/**
	 * Método para simulação de carga de objetos na lista de empréstimos.
	 * @param collectionItem
	 * @param user
	 */
	public void loadLendItem(CollectionItem collectionItem, User user) {
		if(collectionItem.isAvailable()) {
			Lending lend = new Lending(collectionItem, user);
			this.lendingList.add(lend);
			collectionItem.setAvailable(false);
		}
	}
	/**
	 * Método para empréstimo de item da biblioteca passando os parâmetros do código identificador da obra e 
	 * código identificador do usuário que irá fazer o empréstimo.
	 * Para o empréstimo ocorrer é necessário recuperar os objetos do item e do usuário das listas da biblioteca,
	 * o que é feito com os métodos getItem e getUser instanciando os objetos criados.
	 * A seguir são feitos testes com ifs simples para saber se os objetos foram instanciados adequadamente,
	 * caso não tenham sido é exibida uma mensagem de erro e o método é abortado.
	 * Caso os objetos tenham sido instanciados corretamente o método lendItem(CollectionItem, User) é acionado
	 * para terminar o processo.
	 * 
	 * Aqui temos dois métodos com nomes iguais mas parâmetros diferentes, os chamados MÉTODOS SOBRECARREGADOS.
	 * 
	 * @param idItem
	 * @param idUser
	 */
	public void lendItem(int idItem, int idUser) {
		CollectionItem lendCollectionItem = getItemFromList(idItem);
		User borrowUser  =  getUserFromList(idUser);

		if(lendCollectionItem == null) {
			System.out.println("Id item ["+idItem+"] not found.");
			return;
		}

		if(borrowUser == null) {
			System.out.println("User id ["+idUser+"] not found.");
			return;
		}
		
			lendItem(lendCollectionItem, borrowUser);

	}
	
	/**
	 * O método verifica se um determinado item com código de identificação (em formato de inteiro) 
	 * passado por parâmetro existe na lista de itens da
	 * biblioteca, caso o item exista na coleção o objeto representado por ele é retornado pelo método.
	 * @param idItem
	 * @return
	 */
	private CollectionItem getItemFromList(int idItem) {
		for(CollectionItem lendCollectionItem:collectionList) {
			if(lendCollectionItem.getIdItem() == idItem) {
				return lendCollectionItem;
			}
		}
		return null;
		
	}

	/**
	 * O método verifica se um determinado usuário com código de identificação (em formato de inteiro) 
	 * passado por parâmetro existe na lista de usuários da
	 * biblioteca, caso o usuário exista no cadastro o objeto representado por ele é retornado pelo método.
	 * @param idUser
	 * @return
	 */
	private User getUserFromList(int idUser) {
		for(User borrowUser:userList) {
			if(borrowUser.getIdUser() == idUser) {
				return borrowUser;
			}
		}
		return null;
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
		for(Lending l:lendingList) {
			if (l.getCollectionItem().getIdItem() == lend.getCollectionItem().getIdItem()){
				lendingList.remove(l);
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
	 * Método alternativo criado para possibilitar a devolução do item utilizando como parâmetros o código do item e o código do usuário.
	 * Assim como no caso do empréstimo os objetos são recuperados das listas de itens e de usuário e caso sejam encontradas
	 * as correspondências exatas o método genérico para devolução do item é acionado e termina o processso.
	 * 
	 * @param idItem
	 * @param idUser
	 */
	public void returnItem(int idItem,int idUser) {
		CollectionItem returnCollectionItem = getItemFromList(idItem);
		User borrowUser  =  getUserFromList(idUser);
		
		if(returnCollectionItem == null) {
			System.out.println("Id item ["+idItem+"] not found.");
			return;
		}
		
		if(borrowUser == null) {
			System.out.println("User id ["+idUser+"] not found.");
			return;
		}
		returnItem(returnCollectionItem, borrowUser);
	}
	
	/**
	 * Método que exibe a lista de itens cadastrados na collection, que podem ser livros ou
	 * trabalhos acadêmicos, ou quais outros itens que sejam adicionados ao acervo e que
	 * sejam definidos como subclasse de CollectionItem
	 */
	public void listCollection() {
		System.out.print("Library Collection\n");
		for(CollectionItem i: collectionList) {
			System.out.print(i.getIdItem()+"|"+i.getTitle()+" | "+i.getAuthor()+ " | "+i.availableStatus()+"\n");
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
		System.out.print("Lended Items\n");
		if(lendingList.size()>0) {
			for(Lending l: lendingList) {
				System.out.print(l.getCollectionItem().getIdItem()+"|"+l.getCollectionItem().getTitle()+" | "+l.getUser().getName()+" | "+l.getReturnDate()+"\n");
			}
		}else {
			System.out.println("At the moment there is no lended items!\n");
		}
		System.out.println();
	}
	
	/**
	 * Método para listar os usuários armazenados na lista user.
	 * Através de um forEach iterrando o objeto User u através da lista user o resultado
	 * é impresso na tela com os atributos de nome do usuário, cpf e data de nascimento.
	 */
	public void listUsers() {
		System.out.print("User List\n");
		for(User u: userList) {
			System.out.print(u.getIdUser()+"|"+u.getName()+" | "+u.getUserName()+" | "+u.getSocialSecurityNumber()+" | "+u.getDateOfBirth()+"\n");
		}
		System.out.println();
	}
	
}
