package org.upsi.eclipselink.wvisit.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the website_visit database table.
 * 
 */
@Entity
@Table(name="website_visit")
@NamedQuery(name="WebsiteVisit.findAll", query="SELECT w FROM WebsiteVisit w")
public class WebsiteVisit implements Serializable {
	private static final long serialVersionUID = 1L;
	private int tableId;
	private int totalVisits;
	private String visitDate;
	private String websiteName;

	public WebsiteVisit() {
	}


	@Id
	@SequenceGenerator(name="WEBSITE_VISIT_TABLEID_GENERATOR", sequenceName="WEBSITE_VISIT")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WEBSITE_VISIT_TABLEID_GENERATOR")
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


	@Column(name="visit_date")
	public String getVisitDate() {
		return this.visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}


	@Column(name="website_name")
	public String getWebsiteName() {
		return this.websiteName;
	}

	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}

}