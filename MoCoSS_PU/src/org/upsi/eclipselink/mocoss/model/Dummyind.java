package org.upsi.eclipselink.mocoss.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dummyind database table.
 * 
 */
@Entity
@NamedQuery(name="Dummyind.findAll", query="SELECT d FROM Dummyind d")
public class Dummyind implements Serializable {
	private static final long serialVersionUID = 1L;
	private int tableId;
	private String clientCode;
	private String sessionDate;
	private String sessionHourEnd;
	private String sessionHourStart;
	private int sessionNum;

	public Dummyind() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public int getTableId() {
		return this.tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}


	@Lob
	public String getClientCode() {
		return this.clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}


	@Lob
	public String getSessionDate() {
		return this.sessionDate;
	}

	public void setSessionDate(String sessionDate) {
		this.sessionDate = sessionDate;
	}


	@Lob
	public String getSessionHourEnd() {
		return this.sessionHourEnd;
	}

	public void setSessionHourEnd(String sessionHourEnd) {
		this.sessionHourEnd = sessionHourEnd;
	}


	@Lob
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