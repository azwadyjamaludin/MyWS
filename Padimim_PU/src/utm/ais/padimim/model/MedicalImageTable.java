package utm.ais.padimim.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the MEDICAL_IMAGE_TABLE database table.
 * 
 */
@Entity
@Table(name="MEDICAL_IMAGE_TABLE")
@NamedQuery(name="MedicalImageTable.findAll", query="SELECT m FROM MedicalImageTable m")
public class MedicalImageTable implements Serializable {
	private static final long serialVersionUID = 1L;
	private long mitId;
	private Byte[] anondicom;
	private Byte[] dicom;
	private BigDecimal editFlag;
	private Byte[] image;
	private Byte[] imagethumb;
	private String imgFilename;
	private String modality;
	private String patientId;
	private String patientName;

	public MedicalImageTable() {
	}
	
	/*public MedicalImageTable(String imgFilename, Byte[] image) {
		this.imgFilename = imgFilename;
		this.image = image;
	}*/


	@Id
	@SequenceGenerator(name="MEDICAL_IMAGE_TABLE_MITID_GENERATOR", sequenceName="TABLE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEDICAL_IMAGE_TABLE_MITID_GENERATOR")
	@Column(name="MIT_ID")
	public long getMitId() {
		return this.mitId;
	}

	public void setMitId(long mitId) {
		this.mitId = mitId;
	}


	@Lob
	@Column(name = "ANONDICOM")
	@Basic
	public Byte[] getAnondicom() {
		return this.anondicom;
	}

	public void setAnondicom(Byte[] anondicom) {
		this.anondicom = anondicom;
	}


	@Lob
	@Column(name = "DICOM")
	@Basic
	public Byte[] getDicom() {
		return this.dicom;
	}

	public void setDicom(Byte[] dicom) {
		this.dicom = dicom;
	}


	@Column(name="EDIT_FLAG")
	public BigDecimal getEditFlag() {
		return this.editFlag;
	}

	public void setEditFlag(BigDecimal editFlag) {
		this.editFlag = editFlag;
	}

	
	@Lob
	@Column(name = "IMAGE")
	@Basic
	public Byte[] getImage() {
		return this.image;
	}

	public void setImage(Byte[] image) {
		this.image = image;
	}

	
	@Lob
	@Column(name = "IMAGETHUMB")
	@Basic
	public Byte[] getImagethumb() {
		return this.imagethumb;
	}

	public void setImagethumb(Byte[] imagethumb) {
		this.imagethumb = imagethumb;
	}


	@Column(name="IMG_FILENAME")
	public String getImgFilename() {
		return this.imgFilename;
	}

	public void setImgFilename(String imgFilename) {
		this.imgFilename = imgFilename;
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