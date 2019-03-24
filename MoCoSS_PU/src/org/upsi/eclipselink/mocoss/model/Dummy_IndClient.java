package org.upsi.eclipselink.mocoss.model;

import java.io.Serializable;
import javax.persistence.*;


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
	private String clientCode;
	private String clientDetail;
	private String clientName;
	private String discussionCategory;

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


	@Column(name="client_code")
	public String getClientCode() {
		return this.clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
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

}