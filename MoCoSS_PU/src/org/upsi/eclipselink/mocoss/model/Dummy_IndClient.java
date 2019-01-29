package org.upsi.eclipselink.mocoss.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "dummy_IndClient" database table.
 * 
 */
@Entity
@Table(name="\"dummy_IndClient\"")
@NamedQuery(name="Dummy_IndClient.findAll", query="SELECT d FROM Dummy_IndClient d")
public class Dummy_IndClient implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer tableId;
	private String clientDetail;
	private String clientName;
	private String discussionCategory;
	private List<Dummy_IndCoun> dummyIndCouns;

	public Dummy_IndClient() {
	}


	@Id
	@Column(name="table_id")
	public Integer getTableId() {
		return this.tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}


	@Column(name="client_detail")
	public String getClientDetail() {
		return this.clientDetail;
	}

	public void setClientDetail(String clientDetail) {
		this.clientDetail = clientDetail;
	}


	@Column(name="client_name")
	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


	@Column(name="discussion_category")
	public String getDiscussionCategory() {
		return this.discussionCategory;
	}

	public void setDiscussionCategory(String discussionCategory) {
		this.discussionCategory = discussionCategory;
	}


	//bi-directional many-to-one association to Dummy_IndCoun
	@OneToMany(mappedBy="dummyIndClient")
	public List<Dummy_IndCoun> getDummyIndCouns() {
		return this.dummyIndCouns;
	}

	public void setDummyIndCouns(List<Dummy_IndCoun> dummyIndCouns) {
		this.dummyIndCouns = dummyIndCouns;
	}

	public Dummy_IndCoun addDummyIndCoun(Dummy_IndCoun dummyIndCoun) {
		getDummyIndCouns().add(dummyIndCoun);
		dummyIndCoun.setDummyIndClient(this);

		return dummyIndCoun;
	}

	public Dummy_IndCoun removeDummyIndCoun(Dummy_IndCoun dummyIndCoun) {
		getDummyIndCouns().remove(dummyIndCoun);
		dummyIndCoun.setDummyIndClient(null);

		return dummyIndCoun;
	}

}