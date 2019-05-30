package utm.ais.padimim.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PatientRecyclingOrder database table.
 * 
 */
@Entity
@NamedQuery(name="PatientRecyclingOrder.findAll", query="SELECT p FROM PatientRecyclingOrder p")
public class PatientRecyclingOrder implements Serializable {
	private static final long serialVersionUID = 1L;
	private String seq;
	private Resource resource;

	public PatientRecyclingOrder() {
	}


	@Id
	@SequenceGenerator(name="PATIENTRECYCLINGORDER_SEQ_GENERATOR", sequenceName="PATIENTRECYCLINGORDER")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PATIENTRECYCLINGORDER_SEQ_GENERATOR")
	public String getSeq() {
		return this.seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}


	//bi-directional many-to-one association to Resource
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="patientId")
	public Resource getResource() {
		return this.resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

}