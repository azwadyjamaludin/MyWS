package utm.ais.padimim.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Changes database table.
 * 
 */
@Entity
@Table(name="Changes")
@NamedQuery(name="Change.findAll", query="SELECT c FROM Change c")
public class Change implements Serializable {
	private static final long serialVersionUID = 1L;
	private String seq;
	private int changeType;
	private String date;
	private int resourceType;
	private Resource resource;

	public Change() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public String getSeq() {
		return this.seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}


	public int getChangeType() {
		return this.changeType;
	}

	public void setChangeType(int changeType) {
		this.changeType = changeType;
	}


	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public int getResourceType() {
		return this.resourceType;
	}

	public void setResourceType(int resourceType) {
		this.resourceType = resourceType;
	}


	//bi-directional many-to-one association to Resource
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="internalId")
	public Resource getResource() {
		return this.resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

}