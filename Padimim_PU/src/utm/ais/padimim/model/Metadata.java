package utm.ais.padimim.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Metadata database table.
 * 
 */
@Entity
@NamedQuery(name="Metadata.findAll", query="SELECT m FROM Metadata m")
public class Metadata implements Serializable {
	private static final long serialVersionUID = 1L;
	private MetadataPK id;
	private String value;
	private Resource resource;

	public Metadata() {
	}


	@EmbeddedId
	public MetadataPK getId() {
		return this.id;
	}

	public void setId(MetadataPK id) {
		this.id = id;
	}


	@Lob
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