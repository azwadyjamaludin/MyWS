package org.upsi.eclipselink.wvisit.repositories;

import java.util.List;

import javax.persistence.TypedQuery;

import org.upsi.eclipselink.wvisit.em.WVisitEM;
import org.upsi.eclipselink.wvisit.model.WebsiteVisit;



/**
 *Data query for WVisit_PU
 *
 */
public class WebsiteVisitQuery extends WVisitEM {
	private String stringQuery;
	private TypedQuery<WebsiteVisit> tQuery;

	public WebsiteVisitQuery() {	
	}
	
	public List<WebsiteVisit> getList() {
		WVisitEM.startET();
		try {
		stringQuery = "SELECT wv FROM WebsiteVisit wv";
		tQuery = em.createQuery(stringQuery, WebsiteVisit.class);
		return  tQuery.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			WVisitEM.closeEM();
		}
		return null;
	}
	
	public List<WebsiteVisit> getListByTotalVisit() {
		WVisitEM.startET();
		try {
		stringQuery = "SELECT wv FROM WebsiteVisit wv ORDER BY wv.totalVisits DESC";
		tQuery = em.createQuery(stringQuery, WebsiteVisit.class);
		tQuery.setMaxResults(5);
		return tQuery.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			WVisitEM.closeEM();
		}
		return null;
	}
	
	public List<WebsiteVisit> getListByDate(String selectedDate) {
		WVisitEM.startET();
		try {
		stringQuery = "SELECT wv FROM WebsiteVisit wv WHERE wv.visitDate = ? ORDER BY wv.totalVisits DESC";
		tQuery = em.createQuery(stringQuery, WebsiteVisit.class);
		tQuery.setParameter(1, selectedDate);
		tQuery.setMaxResults(5);
		return tQuery.getResultList();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			WVisitEM.closeEM();
		}
		return null;
	}
}
