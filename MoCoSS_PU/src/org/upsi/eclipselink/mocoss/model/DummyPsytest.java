package org.upsi.eclipselink.mocoss.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dummy_psytest database table.
 * 
 */
@Entity
@Table(name="dummy_psytest")
@NamedQuery(name="DummyPsytest.findAll", query="SELECT d FROM DummyPsytest d")
public class DummyPsytest implements Serializable {
	private static final long serialVersionUID = 1L;
	private int tableId;
	private String inventName;
	private String psytestDate;
	private String psytestTimeEnd;
	private String psytestTimeStart;
	private String studentCode;

	public DummyPsytest() {
	}


	@Id
	@SequenceGenerator(name="DUMMY_PSYTEST_TABLEID_GENERATOR", sequenceName="DUMMY_PSYTEST")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DUMMY_PSYTEST_TABLEID_GENERATOR")
	@Column(name="table_id")
	public int getTableId() {
		return this.tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}


	@Column(name="invent_name")
	public String getInventName() {
		return this.inventName;
	}

	public void setInventName(String inventName) {
		this.inventName = inventName;
	}


	@Column(name="psytest_date")
	public String getPsytestDate() {
		return this.psytestDate;
	}

	public void setPsytestDate(String psytestDate) {
		this.psytestDate = psytestDate;
	}


	@Column(name="psytest_time_end")
	public String getPsytestTimeEnd() {
		return this.psytestTimeEnd;
	}

	public void setPsytestTimeEnd(String psytestTimeEnd) {
		this.psytestTimeEnd = psytestTimeEnd;
	}


	@Column(name="psytest_time_start")
	public String getPsytestTimeStart() {
		return this.psytestTimeStart;
	}

	public void setPsytestTimeStart(String psytestTimeStart) {
		this.psytestTimeStart = psytestTimeStart;
	}


	@Column(name="student_code")
	public String getStudentCode() {
		return this.studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

}