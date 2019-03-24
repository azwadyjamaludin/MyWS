package org.upsi.eclipselink.mocoss.model;

import java.io.Serializable;
import javax.persistence.*;


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
	private String clientGroupCode;
	private Integer clientInvolve;
	private String discussionActivity;

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


	@Column(name="client_group_code")
	public String getClientGroupCode() {
		return this.clientGroupCode;
	}

	public void setClientGroupCode(String clientGroupCode) {
		this.clientGroupCode = clientGroupCode;
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

}