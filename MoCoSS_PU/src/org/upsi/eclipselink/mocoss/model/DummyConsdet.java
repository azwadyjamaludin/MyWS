package org.upsi.eclipselink.mocoss.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dummy_consdet database table.
 * 
 */
@Entity
@Table(name="dummy_consdet")
@NamedQuery(name="DummyConsdet.findAll", query="SELECT d FROM DummyConsdet d")
public class DummyConsdet implements Serializable {
	private static final long serialVersionUID = 1L;
	private int tableId;
	private String consEnt;
	private String consField;

	public DummyConsdet() {
	}


	@Id
	@SequenceGenerator(name="DUMMY_CONSDET_TABLEID_GENERATOR", sequenceName="DUMMY_CONSDET")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DUMMY_CONSDET_TABLEID_GENERATOR")
	@Column(name="table_id")
	public int getTableId() {
		return this.tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}


	@Column(name="cons_ent")
	public String getConsEnt() {
		return this.consEnt;
	}

	public void setConsEnt(String consEnt) {
		this.consEnt = consEnt;
	}


	@Column(name="cons_field")
	public String getConsField() {
		return this.consField;
	}

	public void setConsField(String consField) {
		this.consField = consField;
	}

}