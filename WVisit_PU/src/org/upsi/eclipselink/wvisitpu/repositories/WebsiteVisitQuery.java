package org.upsi.eclipselink.wvisitpu.repositories;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.upsi.eclipselink.wvisitpu.em.WVisitEM;
import org.upsi.eclipselink.wvisitpu.model.WebsiteVisit;

/**
 *Data query for WVisit_PU
 *
 */
public class WebsiteVisitQuery extends WVisitEM implements WebsiteVisitRepo {
	private String stringQuery;
	private Query query;
	
	public WebsiteVisitQuery() {
		
	}
	
	@SuppressWarnings("unchecked")
	public List<WebsiteVisit> getList() {
		WebsiteVisitQuery.startET();
		stringQuery = "select id, total_visits, visit_date, website_name from website_visit";
		query = em.createNativeQuery(stringQuery, WebsiteVisit.class);

		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<WebsiteVisit> getListByTotalVisit() {
		WebsiteVisitQuery.startET();
		stringQuery = "select id, total_visits, visit_date, website_name from website_visit order by total_visits desc";
		query = em.createNativeQuery(stringQuery, WebsiteVisit.class);
		query.setMaxResults(5);
		
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<WebsiteVisit> getListByDate(Date selectedDate) {
		WebsiteVisitQuery.startET();
		stringQuery = "select id, total_visits, visit_date, website_name from website_visit where visit_date = ? order by total_visits desc";
		query = em.createNativeQuery(stringQuery, WebsiteVisit.class);
		query.setParameter(1, selectedDate);
		query.setMaxResults(5);
		
		return query.getResultList();
	}
	
	public SimpleDateFormat simpledate() {
		return null;
		
	}

}
