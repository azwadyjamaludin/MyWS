package utm.ais.padimim.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PATIENT_DATA database table.
 * 
 */
@Entity
@Table(name="PATIENT_DATA")
@NamedQuery(name="PatientData.findAll", query="SELECT p FROM PatientData p")
public class PatientData implements Serializable {
	private static final long serialVersionUID = 1L;
	private long tableId;
	private String modality;
	private String patientId;
	private String patientName;

	public PatientData() {
	}


	@Id
	@SequenceGenerator(name="PATIENT_DATA_TABLEID_GENERATOR", sequenceName="TABLE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PATIENT_DATA_TABLEID_GENERATOR")
	@Column(name="TABLE_ID")
	public long getTableId() {
		return this.tableId;
	}

	public void setTableId(long tableId) {
		this.tableId = tableId;
	}


	public String getModality() {
		return this.modality;
	}

	public void setModality(String modality) {
		this.modality = modality;
	}


	@Column(name="PATIENT_ID")
	public String getPatientId() {
		return this.patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}


	@Column(name="PATIENT_NAME")
	public String getPatientName() {
		return this.patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

}