package org.upsi.eclipselink.mocoss.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the "dummy_IndCoun" database table.
 * 
 */
@Entity
@Table(name="\"dummy_IndCoun\"")
@NamedQuery(name="Dummy_IndCoun.findAll", query="SELECT d FROM Dummy_IndCoun d")
public class Dummy_IndCoun implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer tableId;
	private byte[] avFile;
	private Date sessionDate;
	private Time sessionHourEnd;
	private Time sessionHourStart;
	private Integer sessionNum;
	private byte[] sessionReport;
	private Dummy_IndClient dummyIndClient;

	public Dummy_IndCoun() {
	}


	@Id
	@Column(name="table_id")
	public Integer getTableId() {
		return this.tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}


	@Column(name="av_file")
	public byte[] getAvFile() {
		return this.avFile;
	}

	public void setAvFile(byte[] avFile) {
		this.avFile = avFile;
	}


	@Temporal(TemporalType.DATE)
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


	@Column(name="session_report")
	public byte[] getSessionReport() {
		return this.sessionReport;
	}

	public void setSessionReport(byte[] sessionReport) {
		this.sessionReport = sessionReport;
	}


	//bi-directional many-to-one association to Dummy_IndClient
	@ManyToOne
	@JoinColumn(name="client_code", referencedColumnName="client_code")
	public Dummy_IndClient getDummyIndClient() {
		return this.dummyIndClient;
	}

	public void setDummyIndClient(Dummy_IndClient dummyIndClient) {
		this.dummyIndClient = dummyIndClient;
	}

}