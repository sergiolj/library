package classes;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class User {
	private static int idCounter=1; // Variável da Classe (static) Contador de itens da classe User que funciona como identificador para usuários
	private int idUser; // Código identificador do usuário
	private String name;
	private String userName;
	private LocalDate dateOfBirth;
	private String socialSecurityNumber;
	
	public User() {
		this.idUser = idCounter++;	
	}
	
	public User( String name, String userName, LocalDate dateOfBirth, String socialSecurityNumber, String password) {
		this.idUser = idCounter++;
		this.name = name;
		this.userName = userName;
		this.dateOfBirth = dateOfBirth;
		this.socialSecurityNumber = socialSecurityNumber;
	}
	
	public int getIdUser() {
		return idUser;
	}

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}


	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}


	/**
	 * Método estático usado para criar instâncias com parâmtros passados por teclado pelo usuário.
	 * Os atributos do usuário são todos do tipo String, com exceção da data de nascimento que é do tipo
	 * LocalDate. Para tratar posssíveis erros de inserção da data foi criado um loop while e um tratamento de
	 * exceção com try catch.
	 * A função LocalDate.parse(CharSequence) faz a conversão do dado para tipo LocalDate.
	 * 
	 * Caso todos os parâmetros sejam fornecidos corretamente o método retorna um objeto do tipo User.
	 * @param sc
	 * @return
	 */
	public static User createUser (Scanner sc) {
		User user = new User();
		System.out.print("Insert name: ");
		user.setName(sc.nextLine());

		System.out.print("Insert username: ");
		user.setUserName(sc.nextLine());

		System.out.print("Insert Social Security Number: ");
		user.setSocialSecurityNumber(sc.nextLine());




		while(user.getDateOfBirth() == null) {
			try {
				System.out.print("Insert date of birth (aaaa-mm-dd): ");
				String date = sc.nextLine();
				user.setDateOfBirth((LocalDate.parse(date)));
				System.out.println();
				
			}catch(DateTimeParseException e){
				System.out.print("\nInvalid date format. Format expected (aaaa-mm-dd).\n");
			}
		}
		return user;
	}
	
}
