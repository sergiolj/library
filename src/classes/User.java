package classes;

import java.time.LocalDate;

public class User {
	private String name;
	private String userName;
	private LocalDate dateOfBirth;
	private String socialSecurityNumber;
	private String password;
	
	public User() {}
	
	public User( String name, String userName, LocalDate dateOfBirth, String socialSecurityNumber, String password) {
		this.name = name;
		this.userName = userName;
		this.dateOfBirth = dateOfBirth;
		this.socialSecurityNumber = socialSecurityNumber;
		this.password = password;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void createUser() {
		
	}
	
}
