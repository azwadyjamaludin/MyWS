package org.upsi.eclipselink.wvisit.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the websitevisit database table.
 * 
 */
@Entity
@NamedQuery(name="Websitevisit.findAll", query="SELECT w FROM Websitevisit w")
public class Websitevisit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="total_visits")
	private int totalVisits;

	@Lob
	@Column(name="visit_date")
	private String visitDate;

	@Lob
	@Column(name="website_name")
	private String websiteName;

	public Websitevisit() {
	}

	public int getTotalVisits() {
		return this.totalVisits;
	}

	public void setTotalVisits(int totalVisits) {
		this.totalVisits = totalVisits;
	}

	public String getVisitDate() {
		return this.visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

	public String getWebsiteName() {
		return this.websiteName;
	}

	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}

}