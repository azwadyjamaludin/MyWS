package utm.ais.padimim.repositories;

public class DicomTagL2 {
	private String patientName;
	private String patientID;
	private String DOB;
	private String sex;
	private String studyDate;
	private String studyName;
	private String institution;
	private String accessNumber;
	private String id;
	private String className;
	
	public DicomTagL2(
			String patientName,
			String patientID,
			String DOB,
			String sex,
			String studyDate,
			String studyName,
			String institution,
			String accessNumber, String id) {
		this.className = "DicomTagL2";
		this.patientName = patientName;
		this.patientID = patientID;
		this.DOB = DOB;
		this.sex = sex;
		this.studyDate = studyDate;
		this.studyName = studyName;
		this.institution = institution;
		this.accessNumber = accessNumber;
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public String getPatientID() {
		return patientID;
	}

	public String getDOB() {
		return DOB;
	}

	public String getSex() {
		return sex;
	}

	public String getStudyDate() {
		return studyDate;
	}

	public String getStudyName() {
		return studyName;
	}

	public String getInstitution() {
		return institution;
	}

	public String getAccessNumber() {
		return accessNumber;
	}

	public String getId() {
		return id;
	}

	public String getClassName() {
		return className;
	}
	
	

	

}
