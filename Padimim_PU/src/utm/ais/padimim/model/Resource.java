package utm.ais.padimim.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the Resources database table.
 * 
 */
@Entity
@Table(name="Resources")
@NamedQuery(name="Resource.findAll", query="SELECT r FROM Resource r")
public class Resource implements Serializable {
	private static final long serialVersionUID = 1L;
	private String internalId;
	private BigInteger parentId;
	private String publicId;
	private int resourceType;
	private List<AttachedFile> attachedFiles;
	private List<DicomIdentifier> dicomIdentifiers;
	private List<MainDicomTag> mainDicomTags;
	private List<Metadata> metadata;
	private List<PatientRecyclingOrder> patientRecyclingOrders;

	public Resource() {
	}


	@Id
	@SequenceGenerator(name="RESOURCES_INTERNALID_GENERATOR", sequenceName="RESOURCES")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RESOURCES_INTERNALID_GENERATOR")
	public String getInternalId() {
		return this.internalId;
	}

	public void setInternalId(String internalId) {
		this.internalId = internalId;
	}


	public BigInteger getParentId() {
		return this.parentId;
	}

	public void setParentId(BigInteger parentId) {
		this.parentId = parentId;
	}


	public String getPublicId() {
		return this.publicId;
	}

	public void setPublicId(String publicId) {
		this.publicId = publicId;
	}


	public int getResourceType() {
		return this.resourceType;
	}

	public void setResourceType(int resourceType) {
		this.resourceType = resourceType;
	}


	//bi-directional many-to-one association to AttachedFile
	@OneToMany(mappedBy="resource")
	public List<AttachedFile> getAttachedFiles() {
		return this.attachedFiles;
	}

	public void setAttachedFiles(List<AttachedFile> attachedFiles) {
		this.attachedFiles = attachedFiles;
	}

	public AttachedFile addAttachedFile(AttachedFile attachedFile) {
		getAttachedFiles().add(attachedFile);
		attachedFile.setResource(this);

		return attachedFile;
	}

	public AttachedFile removeAttachedFile(AttachedFile attachedFile) {
		getAttachedFiles().remove(attachedFile);
		attachedFile.setResource(null);

		return attachedFile;
	}


	//bi-directional many-to-one association to DicomIdentifier
	@OneToMany(mappedBy="resource")
	public List<DicomIdentifier> getDicomIdentifiers() {
		return this.dicomIdentifiers;
	}

	public void setDicomIdentifiers(List<DicomIdentifier> dicomIdentifiers) {
		this.dicomIdentifiers = dicomIdentifiers;
	}

	public DicomIdentifier addDicomIdentifier(DicomIdentifier dicomIdentifier) {
		getDicomIdentifiers().add(dicomIdentifier);
		dicomIdentifier.setResource(this);

		return dicomIdentifier;
	}

	public DicomIdentifier removeDicomIdentifier(DicomIdentifier dicomIdentifier) {
		getDicomIdentifiers().remove(dicomIdentifier);
		dicomIdentifier.setResource(null);

		return dicomIdentifier;
	}


	//bi-directional many-to-one association to MainDicomTag
	@OneToMany(mappedBy="resource")
	public List<MainDicomTag> getMainDicomTags() {
		return this.mainDicomTags;
	}

	public void setMainDicomTags(List<MainDicomTag> mainDicomTags) {
		this.mainDicomTags = mainDicomTags;
	}

	public MainDicomTag addMainDicomTag(MainDicomTag mainDicomTag) {
		getMainDicomTags().add(mainDicomTag);
		mainDicomTag.setResource(this);

		return mainDicomTag;
	}

	public MainDicomTag removeMainDicomTag(MainDicomTag mainDicomTag) {
		getMainDicomTags().remove(mainDicomTag);
		mainDicomTag.setResource(null);

		return mainDicomTag;
	}


	//bi-directional many-to-one association to Metadata
	@OneToMany(mappedBy="resource")
	public List<Metadata> getMetadata() {
		return this.metadata;
	}

	public void setMetadata(List<Metadata> metadata) {
		this.metadata = metadata;
	}

	public Metadata addMetadata(Metadata metadata) {
		getMetadata().add(metadata);
		metadata.setResource(this);

		return metadata;
	}

	public Metadata removeMetadata(Metadata metadata) {
		getMetadata().remove(metadata);
		metadata.setResource(null);

		return metadata;
	}


	//bi-directional many-to-one association to PatientRecyclingOrder
	@OneToMany(mappedBy="resource")
	public List<PatientRecyclingOrder> getPatientRecyclingOrders() {
		return this.patientRecyclingOrders;
	}

	public void setPatientRecyclingOrders(List<PatientRecyclingOrder> patientRecyclingOrders) {
		this.patientRecyclingOrders = patientRecyclingOrders;
	}

	public PatientRecyclingOrder addPatientRecyclingOrder(PatientRecyclingOrder patientRecyclingOrder) {
		getPatientRecyclingOrders().add(patientRecyclingOrder);
		patientRecyclingOrder.setResource(this);

		return patientRecyclingOrder;
	}

	public PatientRecyclingOrder removePatientRecyclingOrder(PatientRecyclingOrder patientRecyclingOrder) {
		getPatientRecyclingOrders().remove(patientRecyclingOrder);
		patientRecyclingOrder.setResource(null);

		return patientRecyclingOrder;
	}

}