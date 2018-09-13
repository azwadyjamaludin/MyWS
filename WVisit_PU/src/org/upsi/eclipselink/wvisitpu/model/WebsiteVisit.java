package org.upsi.eclipselink.wvisitpu.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


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
	private BigDecimal totalVisits;
	private Date visitDate;
	private String websiteName;
	
	public WebsiteVisit() {
	}
	
	@Id
	@SequenceGenerator(name="WEBSITE_VISIT_TABLEID_GENERATOR", sequenceName="WEBSITE_VISIT")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WEBSITE_VISIT_TABLEID_GENERATOR")
	@Column(name="table_id")
	public Integer getTableId() {
		return this.tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}


	@Column(name="total_visits")
	public BigDecimal getTotalVisits() {
		return this.totalVisits;
	}

	public void setTotalVisits(BigDecimal totalVisits) {
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