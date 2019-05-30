package org.upsi.eclipselink.mocoss.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dummy_refdet database table.
 * 
 */
@Entity
@Table(name="dummy_refdet")
@NamedQuery(name="DummyRefdet.findAll", query="SELECT d FROM DummyRefdet d")
public class DummyRefdet implements Serializable {
	private static final long serialVersionUID = 1L;
	private int tableId;
	private String referReason;
	private String referStud;

	public DummyRefdet() {
	}


	@Id
	@SequenceGenerator(name="DUMMY_REFDET_TABLEID_GENERATOR", sequenceName="DUMMY_REFDET")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DUMMY_REFDET_TABLEID_GENERATOR")
	@Column(name="table_id")
	public int getTableId() {
		return this.tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}


	@Column(name="refer_reason")
	public String getReferReason() {
		return this.referReason;
	}

	public void setReferReason(String referReason) {
		this.referReason = referReason;
	}


	@Column(name="refer_stud")
	public String getReferStud() {
		return this.referStud;
	}

	public void setReferStud(String referStud) {
		this.referStud = referStud;
	}

}