package org.upsi.eclipselink.wvisit.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the data database table.
 * 
 */
@Entity
@NamedQuery(name="Data.findAll", query="SELECT d FROM Data d")
public class Data implements Serializable {
	private static final long serialVersionUID = 1L;
	private int tableId;
	private int totalVisits;
	private String visitDate;
	private String websiteName;

	public Data() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="table_id")
	public int getTableId() {
		return this.tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}


	@Column(name="total_visits")
	public int getTotalVisits() {
		return this.totalVisits;
	}

	public void setTotalVisits(int totalVisits) {
		this.totalVisits = totalVisits;
	}


	@Lob
	@Column(name="visit_date")
	public String getVisitDate() {
		return this.visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}


	@Lob
	@Column(name="website_name")
	public String getWebsiteName() {
		return this.websiteName;
	}

	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}

}