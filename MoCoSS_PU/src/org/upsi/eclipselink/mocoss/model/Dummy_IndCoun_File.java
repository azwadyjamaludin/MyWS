package org.upsi.eclipselink.mocoss.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "dummy_IndCoun_File" database table.
 * 
 */
@Entity
@Table(name="\"dummy_IndCoun_File\"")
@NamedQuery(name="Dummy_IndCoun_File.findAll", query="SELECT d FROM Dummy_IndCoun_File d")
public class Dummy_IndCoun_File implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer tableId;
	private byte[] avFile;
	private Date sessionDate;
	private byte[] sessionReport;

	public Dummy_IndCoun_File() {
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


	@Column(name="session_report")
	public byte[] getSessionReport() {
		return this.sessionReport;
	}

	public void setSessionReport(byte[] sessionReport) {
		this.sessionReport = sessionReport;
	}

}