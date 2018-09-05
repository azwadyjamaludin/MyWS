package org.upsi.eclipselink.wvisitpu.repositories;

import java.util.Date;
import java.util.List;

import org.upsi.eclipselink.wvisitpu.model.WebsiteVisit;

/**
 * Data interface implementation for data query in WVisit_PU
 * 
 */
public interface WebsiteVisitInterface {
	
	List<WebsiteVisit> getList();
	
	List<WebsiteVisit> getListByTotalVisit();
	
	public List<WebsiteVisit> getListByDate(Date selectedDate);

}
