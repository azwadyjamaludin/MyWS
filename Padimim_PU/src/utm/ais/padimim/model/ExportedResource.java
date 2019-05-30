package utm.ais.padimim.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ExportedResources database table.
 * 
 */
@Entity
@Table(name="ExportedResources")
@NamedQuery(name="ExportedResource.findAll", query="SELECT e FROM ExportedResource e")
public class ExportedResource implements Serializable {
	private static final long serialVersionUID = 1L;
	private String seq;
	private String date;
	private String patientId;
	private String publicId;
	private String remoteModality;
	private int resourceType;
	private String seriesInstanceUid;
	private String sopInstanceUid;
	private String studyInstanceUid;

	public ExportedResource() {
	}


	@Id
	@SequenceGenerator(name="EXPORTEDRESOURCES_SEQ_GENERATOR", sequenceName="EXPORTEDRESOURCES")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXPORTEDRESOURCES_SEQ_GENERATOR")
	public String getSeq() {
		return this.seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}


	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public String getPatientId() {
		return this.patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}


	public String getPublicId() {
		return this.publicId;
	}

	public void setPublicId(String publicId) {
		this.publicId = publicId;
	}


	@Lob
	public String getRemoteModality() {
		return this.remoteModality;
	}

	public void setRemoteModality(String remoteModality) {
		this.remoteModality = remoteModality;
	}


	public int getResourceType() {
		return this.resourceType;
	}

	public void setResourceType(int resourceType) {
		this.resourceType = resourceType;
	}


	@Lob
	public String getSeriesInstanceUid() {
		return this.seriesInstanceUid;
	}

	public void setSeriesInstanceUid(String seriesInstanceUid) {
		this.seriesInstanceUid = seriesInstanceUid;
	}


	@Lob
	public String getSopInstanceUid() {
		return this.sopInstanceUid;
	}

	public void setSopInstanceUid(String sopInstanceUid) {
		this.sopInstanceUid = sopInstanceUid;
	}


	@Lob
	public String getStudyInstanceUid() {
		return this.studyInstanceUid;
	}

	public void setStudyInstanceUid(String studyInstanceUid) {
		this.studyInstanceUid = studyInstanceUid;
	}

}