package utm.ais.padimim.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MainDicomTags database table.
 * 
 */
@Entity
@Table(name="MainDicomTags")
@NamedQuery(name="MainDicomTag.findAll", query="SELECT m FROM MainDicomTag m")
public class MainDicomTag implements Serializable {
	private static final long serialVersionUID = 1L;
	private MainDicomTagPK id;
	private String value;
	private Resource resource;

	public MainDicomTag() {
	}


	@EmbeddedId
	public MainDicomTagPK getId() {
		return this.id;
	}

	public void setId(MainDicomTagPK id) {
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