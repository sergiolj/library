package classes;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class User {
	private static int idCounter=1;
	private int idUser;
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



	public static User createUser (Scanner sc) {
		User user = new User();
		System.out.print("Insert name: ");
		user.setName(sc.nextLine());
		
		System.out.print("\nInsert username: ");
		user.setUserName(sc.nextLine());
		
		System.out.print("\nInsert Social Security Number");
		user.setSocialSecurityNumber(sc.nextLine());
		
		System.out.println("\nInsert date of birth (aaaa-mm-dd)");
		String date = sc.nextLine();
		try {
			user.setDateOfBirth((LocalDate.parse(date)));
		}catch(DateTimeParseException e){
			System.out.println("Invalid date format. Format expected (aaaa-mm-dd).");
		}
		
		return user;
	}
	
}
