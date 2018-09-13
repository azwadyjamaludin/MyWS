package org.upsi.eclipselink.wvisitpu.repositories;

import java.util.List;

import javax.persistence.TypedQuery;

import org.upsi.eclipselink.wvisitpu.em.WVisitEM;
import org.upsi.eclipselink.wvisitpu.model.WebsiteVisit;

/**
 *Data query for WVisit_PU
 *
 */
public class WebsiteVisitQuery extends WVisitEM implements WebsiteVisitInterface {
	private String stringQuery;
	private String className = "WebsiteVisitQuery";
	private TypedQuery<WebsiteVisit> tQuery;

	public WebsiteVisitQuery() {	
	}
	
	@Override
	public void PUName(String pu_name) {
		pu_name = className;
	}

	
	public List<WebsiteVisit> getList() {
		WVisitEM.startET();
		stringQuery = "SELECT wv FROM WebsiteVisit wv";
		tQuery = em.createQuery(stringQuery, WebsiteVisit.class);
		return  tQuery.getResultList();
	}
	
	public List<WebsiteVisit> getListByTotalVisit() {
		WVisitEM.startET();
		stringQuery = "SELECT wv FROM WebsiteVisit wv ORDER BY wv.totalVisits DESC";
		tQuery = em.createQuery(stringQuery, WebsiteVisit.class);
		tQuery.setMaxResults(5);
		return tQuery.getResultList();
	}
	
	public List<WebsiteVisit> getListByDate(String selectedDate) {
		WVisitEM.startET();
		stringQuery = "SELECT wv FROM WebsiteVisit wv WHERE wv.visitDate = ? ORDER BY wv.totalVisits DESC";
		tQuery = em.createQuery(stringQuery, WebsiteVisit.class);
		tQuery.setParameter(1, selectedDate);
		tQuery.setMaxResults(5);
		return tQuery.getResultList();
	}
}
