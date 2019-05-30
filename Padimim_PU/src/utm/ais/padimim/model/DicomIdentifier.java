package utm.ais.padimim.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DicomIdentifiers database table.
 * 
 */
@Entity
@Table(name="DicomIdentifiers")
@NamedQuery(name="DicomIdentifier.findAll", query="SELECT d FROM DicomIdentifier d")
public class DicomIdentifier implements Serializable {
	private static final long serialVersionUID = 1L;
	private DicomIdentifierPK id;
	private String value;
	private Resource resource;

	public DicomIdentifier() {
	}


	@EmbeddedId
	public DicomIdentifierPK getId() {
		return this.id;
	}

	public void setId(DicomIdentifierPK id) {
		this.id = id;
	}


	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}


	//bi-directional many-to-one association to Resource
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	public Resource getResource() {
		return this.resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

}