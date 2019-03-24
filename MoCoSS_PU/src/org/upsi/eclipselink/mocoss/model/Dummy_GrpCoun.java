package org.upsi.eclipselink.mocoss.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import static javax.persistence.TemporalType.TIMESTAMP;


/**
 * The persistent class for the "dummy_GrpCoun" database table.
 * 
 */
@Entity
@Table(name="\"dummy_GrpCoun\"")
@NamedQuery(name="Dummy_GrpCoun.findAll", query="SELECT d FROM Dummy_GrpCoun d")
public class Dummy_GrpCoun implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer tableId;
	private String clientGroupCode;
	private Date sessionDate;
	private Time sessionHourEnd;
	private Time sessionHourStart;
	private Integer sessionNum;

	public Dummy_GrpCoun() {
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


	@Temporal(TIMESTAMP)
	@Column(name="session_date")
	public Date getSessionDate() {
		return this.sessionDate;
	}

	public void setSessionDate(Date sessionDate) {
		this.sessionDate = sessionDate;
	}


	@Column(name="session_hour_end")
	public Time getSessionHourEnd() {
		return this.sessionHourEnd;
	}

	public void setSessionHourEnd(Time sessionHourEnd) {
		this.sessionHourEnd = sessionHourEnd;
	}


	@Column(name="session_hour_start")
	public Time getSessionHourStart() {
		return this.sessionHourStart;
	}

	public void setSessionHourStart(Time sessionHourStart) {
		this.sessionHourStart = sessionHourStart;
	}


	@Column(name="session_num")
	public Integer getSessionNum() {
		return this.sessionNum;
	}

	public void setSessionNum(Integer sessionNum) {
		this.sessionNum = sessionNum;
	}

}