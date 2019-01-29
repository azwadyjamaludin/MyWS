package org.upsi.eclipselink.mocoss.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "dummy_GrpClient" database table.
 * 
 */
@Entity
@Table(name="\"dummy_GrpClient\"")
@NamedQuery(name="Dummy_GrpClient.findAll", query="SELECT d FROM Dummy_GrpClient d")
public class Dummy_GrpClient implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer tableId;
	private Integer clientInvolve;
	private String discussionActivity;
	private List<Dummy_GrpCoun> dummyGrpCouns;

	public Dummy_GrpClient() {
	}


	@Id
	@Column(name="table_id")
	public Integer getTableId() {
		return this.tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}


	@Column(name="client_involve")
	public Integer getClientInvolve() {
		return this.clientInvolve;
	}

	public void setClientInvolve(Integer clientInvolve) {
		this.clientInvolve = clientInvolve;
	}


	@Column(name="discussion_activity")
	public String getDiscussionActivity() {
		return this.discussionActivity;
	}

	public void setDiscussionActivity(String discussionActivity) {
		this.discussionActivity = discussionActivity;
	}


	//bi-directional many-to-one association to Dummy_GrpCoun
	@OneToMany(mappedBy="dummyGrpClient")
	public List<Dummy_GrpCoun> getDummyGrpCouns() {
		return this.dummyGrpCouns;
	}

	public void setDummyGrpCouns(List<Dummy_GrpCoun> dummyGrpCouns) {
		this.dummyGrpCouns = dummyGrpCouns;
	}

	public Dummy_GrpCoun addDummyGrpCoun(Dummy_GrpCoun dummyGrpCoun) {
		getDummyGrpCouns().add(dummyGrpCoun);
		dummyGrpCoun.setDummyGrpClient(this);

		return dummyGrpCoun;
	}

	public Dummy_GrpCoun removeDummyGrpCoun(Dummy_GrpCoun dummyGrpCoun) {
		getDummyGrpCouns().remove(dummyGrpCoun);
		dummyGrpCoun.setDummyGrpClient(null);

		return dummyGrpCoun;
	}

}