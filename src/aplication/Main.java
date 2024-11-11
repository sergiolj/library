package aplication;

import java.time.LocalDate;

import classes.*;
import classes.AcademicWork.WorkType;

public class Main {
	public static void main(String[] args) {
		Library myLibrary = new Library();
		
		Book book1 = new Book("Capitães de Areia", "Jorge Amado", 342, 1937, 1, 1937,"Editora José Olympio");
		Book book2 = new Book("O País do Carnaval","Jorge Amado", 176, 2011, 1, 2011, "Companhia das Letras");
		Book book3 = new Book("Endurance", "Alfred Lasing", 282, 1959,1, 1959,"MCGRAW HILL");
		Book book4 = new Book("Mar sem Fim", "Amyr Klink", 308, 2000, 1, 2000, "Companhia das Letras");
		Book book5 = new Book("O Velho e o Mar", "Ernest Hemingway", 126, 1952, 107, 2013,"Bertrand Brasil");
		AcademicWork essay = new AcademicWork("As mentiras que as IAs contam", "Sérgio Lopes Júnior", 23, WorkType.ESSAY, 2024, "Universidade Católica do Salvador");
		AcademicWork finalPaper = new AcademicWork("Melhoria de um Processo Especializado em Customização e Manutenção de Software Legado",
				"Luiz E. P. Mata", 172, WorkType.FINALPAPER, 2015, "UNISUL - Universidade do Sul de Santa Catarina");
		AcademicWork thesis = new AcademicWork("Algoritmos de criptografia quântica, uma abordagem prática", "Sérgio Lopes Júnior", 987, WorkType.THESIS, 2032, "MIT - Massachusetts Instituct of Technology");	
		
		myLibrary.addCollectionItem(book1);
		myLibrary.addCollectionItem(book2);
		myLibrary.addCollectionItem(book3);
		myLibrary.addCollectionItem(book4);
		myLibrary.addCollectionItem(book5);
		myLibrary.addCollectionItem(essay);
		myLibrary.addCollectionItem(finalPaper);
		myLibrary.addCollectionItem(thesis);
		
		myLibrary.listCollection();
		
		
		User user1 = new User("Sérgio Lopes Júnior", LocalDate.of(1973, 9, 25), "5543654365","1234");
		User user2 = new User("Itana Nogueira Nunes", LocalDate.of(1969, 6, 5), "1233213214", "1234");
		
		myLibrary.registerUser(user1);
		
		myLibrary.listUser();
		
		myLibrary.lendItem(book1, user1);
		myLibrary.lendItem(book4, user1);
		
		myLibrary.lendItem(book1, user2);
		
		myLibrary.listCollection();
		
		myLibrary.listLendedItems();
		
		myLibrary.returnItem(book1, user1);
		
		myLibrary.listLendedItems();
	}
}
