package org.upsi.eclipselink.mocoss.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dummy_ind database table.
 * 
 */
@Entity
@Table(name="dummy_ind")
@NamedQuery(name="DummyInd.findAll", query="SELECT d FROM DummyInd d")
public class DummyInd implements Serializable {
	private static final long serialVersionUID = 1L;
	private int tableId;
	private String clientCode;
	private String sessionDate;
	private String sessionHourEnd;
	private String sessionHourStart;
	private int sessionNum;

	public DummyInd() {
	}


	@Id
	@SequenceGenerator(name="DUMMY_IND_TABLEID_GENERATOR", sequenceName="DUMMY_IND")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DUMMY_IND_TABLEID_GENERATOR")
	@Column(name="table_id")
	public int getTableId() {
		return this.tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}


	public String getClientCode() {
		return this.clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
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