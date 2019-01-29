package org.upsi.eclipselink.wvisit.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the website_visit database table.
 * 
 */
@Entity
@Table(name="website_visit")
@NamedQuery(name="WebsiteVisit.findAll", query="SELECT w FROM WebsiteVisit w")
public class WebsiteVisit implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer tableId;
	private Integer totalVisits;
	private Date visitDate;
	private String websiteName;

	public WebsiteVisit() {
	}


	@Id
	@SequenceGenerator(name="WEBSITE_VISIT_TABLEID_GENERATOR", sequenceName="TABLE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WEBSITE_VISIT_TABLEID_GENERATOR")
	@Column(name="table_id")
	public Integer getTableId() {
		return this.tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}


	@Column(name="total_visits")
	public Integer getTotalVisits() {
		return this.totalVisits;
	}

	public void setTotalVisits(Integer totalVisits) {
		this.totalVisits = totalVisits;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="visit_date")
	public Date getVisitDate() {
		return this.visitDate;
	}

	public void setVisitDate(Date visitDate) {
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