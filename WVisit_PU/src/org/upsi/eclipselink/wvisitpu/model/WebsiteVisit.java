package org.upsi.eclipselink.wvisitpu.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
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
	private Integer id;
	private BigDecimal totalVisits;
	private Date visitDate;
	private String websiteName;

	public WebsiteVisit() {
	}


	@Id
	@SequenceGenerator(name="WEBSITE_VISIT_ID_GENERATOR", sequenceName="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WEBSITE_VISIT_ID_GENERATOR")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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