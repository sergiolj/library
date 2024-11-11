package classes;

public class AcademicWork extends CollectionItem{
	private String institution;
	private WorkType worktype;
	public enum WorkType{
		THESIS, DISSERTATION, FINALPAPER, ESSAY
	}
	
	//Construtor
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
	public void listCollection() {
		// TODO Auto-generated method stub
		
	}
		
}
