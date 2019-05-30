package org.upsi.eclipselink.mocoss.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dummy_grp database table.
 * 
 */
@Entity
@Table(name="dummy_grp")
@NamedQuery(name="DummyGrp.findAll", query="SELECT d FROM DummyGrp d")
public class DummyGrp implements Serializable {
	private static final long serialVersionUID = 1L;
	private int tableId;
	private String clientGroupCode;
	private String sessionDate;
	private String sessionHourEnd;
	private String sessionHourStart;
	private int sessionNum;

	public DummyGrp() {
	}


	@Id
	@SequenceGenerator(name="DUMMY_GRP_TABLEID_GENERATOR", sequenceName="DUMMY_GRP")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DUMMY_GRP_TABLEID_GENERATOR")
	@Column(name="table_id")
	public int getTableId() {
		return this.tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}


	public String getClientGroupCode() {
		return this.clientGroupCode;
	}

	public void setClientGroupCode(String clientGroupCode) {
		this.clientGroupCode = clientGroupCode;
	}


	public String getSessionDate() {
		return this.sessionDate;
	}

	public void setSessionDate(String sessionDate) {
		this.sessionDate = sessionDate;
	}


	public String getSessionHourEnd() {
		return this.sessionHourEnd;
	}

	public void setSessionHourEnd(String sessionHourEnd) {
		this.sessionHourEnd = sessionHourEnd;
	}


	public String getSessionHourStart() {
		return this.sessionHourStart;
	}

	public void setSessionHourStart(String sessionHourStart) {
		this.sessionHourStart = sessionHourStart;
	}


	public int getSessionNum() {
		return this.sessionNum;
	}

	public void setSessionNum(int sessionNum) {
		this.sessionNum = sessionNum;
	}

}