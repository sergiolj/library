package classes;

import classes.AcademicWork.WorkType;

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
	 */
	public int lendPeriod() {
		return 30;
	}

	@Override
	public static CollectionItem createCollectionItem() {
		
		AcademicWork thesis = new AcademicWork("Algoritmos de criptografia quântica, uma abordagem prática", "Sérgio Lopes Júnior", 987, WorkType.THESIS, 2032, "MIT - Massachusetts Instituct of Technology");	
		return thesis;
	}
		
}
