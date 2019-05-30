package utm.ais.padimim.repositories;

public class DicomTag {
	private String patientName;
	private String patientID;
	private String id;
	private String className;
	
	public DicomTag(String patientName,String patientID,String id) {
		this.className = "DicomTag";
		this.patientName = patientName;
		this.patientID = patientID;
		this.id = id;
	}

	
	public String getPatientName() {
		return patientName;
	}


	public String getPatientID() {
		return patientID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

}
