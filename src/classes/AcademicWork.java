package classes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AcademicWork extends CollectionItem{
	private String institution;
	private WorkType worktype;
	public enum WorkType{
		THESIS, DISSERTATION, FINALPAPER, ESSAY
	}
	
	//Construtor
	public AcademicWork() {}
	
	public AcademicWork(String title, String author, int pageNumbers, WorkType worktype, int publicationYear, String institution) {
		super(title, author, pageNumbers, publicationYear);
		this.institution = institution;
		this.worktype = worktype;
	}
	
	//Getters and Setters
	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public WorkType getWorktype() {
		return worktype;
	}

	public void setWorktype(WorkType worktype) {
		this.worktype = worktype;
	}

	@Override
	/**
	 * Trabalhos academicos podem ter um prazo de empréstimo de até 30 dias
	 * Override originário da interface LendRules.
	 */
	public int lendPeriod() {
		return 30;
	}

	@Override
	/**
	 * Método abstrato definido na superclasse CollectionItem para ser SOBREESCRITO
	 * para cada classe que herdar a CollectionItem, deste modo itens com diferentes características
	 * podem ser criados e modificados sob demanda.
	 * O atributo de enum utilizado para padronização da nomenclatura dos trabalhos acadêmicos precisou de um
	 * método específico para seu preenchimento em virtude da complexidade do mesmo.
	 * 
	 */
	public CollectionItem createCollectionItem(Scanner sc) {	
		AcademicWork academicPublication = new AcademicWork();
		
		System.out.print("\nInsert a new academic work to Library Collection\n"
				+ "Insert title: ");
		academicPublication.setTitle(sc.nextLine());
		
		System.out.print("Insert author: ");
		academicPublication.setAuthor(sc.nextLine());
		

		while(academicPublication.getPageNumbers() <=0) {
			try {
				System.out.print("Insert number of pages: ");
				academicPublication.setPageNumbers(sc.nextInt());
				sc.nextLine();

			}catch (InputMismatchException e) {
				System.out.println("Invalid option. Only numbers are accepted.\n");
				sc.nextLine(); // Cleaning buffer to avoid ifinite loop behavior
				//Cada erro conta como um objeto criado no super.idCounter, como resolver?
			}
		}
		
		
		System.out.print("Inform work type classification: ");
		WorkType worktype = chooseWorkType(sc);
		academicPublication.setWorktype(worktype);


		while(academicPublication.getPublicationYear() <=0) {
			try {
				System.out.print("Insert publication year: ");
				academicPublication.setPublicationYear(sc.nextInt());
				sc.nextLine();

			}catch (InputMismatchException e) {
				System.out.println("Invalid option. Only numbers are accepted.\n");
				sc.nextLine(); // Cleaning buffer to avoid ifinite loop behavior
				//Cada erro conta como um objeto criado no super.idCounter, como resolver?
			}
		}
		
		System.out.print("Insert institution: ");
		academicPublication.setInstitution(sc.nextLine());
		System.out.println();

		return academicPublication;
	}

	/**
	 * Método criado para possibilitar ao usuário a escolha do tipo de trabalho acadêmico que será
	 * inserido no acervo da bilbioteca.
	 * @param sc
	 * @return
	 */
	private WorkType chooseWorkType(Scanner sc) {
		int option=0;
		boolean toChoose =  false;

		while(!toChoose) {
			System.out.println("[0] - ESSAY - "
					+ "[1] - FINALPAPER - "
					+ "[2] - DISSERTATION - "
					+ "[3] - THESIS : ");
			try {
				option=sc.nextInt();
				sc.nextLine();

				if(option>=0 && option<=3) {

					switch(option) {
					case 0:
						toChoose=true;
						return WorkType.ESSAY;
					case 1:
						toChoose=true;
						return WorkType.FINALPAPER;
					case 2:
						toChoose=true;
						return WorkType.DISSERTATION;
					case 3:
						toChoose=true;
						return WorkType.THESIS;
					default:
						System.out.println("Invalid option. Try again.");
						break;
					}
				}else {
					System.out.println("Invalid option. Choose any option between 0-3");
				}
			}catch (InputMismatchException e) {
				System.out.println("Invalid option. Only numbers are accepted.");
				sc.nextLine(); // Cleaning buffer to avoid ifinite loop behavior
			}
		}
		return null;
	}

	@Override
	public double lateReturnFee() {
		// TODO Auto-generated method stub
		return 0;
	}
}
