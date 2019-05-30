package org.upsi.eclipselink.mocoss.repositories;

import java.util.List;

import javax.persistence.TypedQuery;

import org.upsi.eclipselink.mocoss.em.MoCoSSEM;
import org.upsi.eclipselink.mocoss.model.DummyConsdet;
import org.upsi.eclipselink.mocoss.model.DummyGrp;
import org.upsi.eclipselink.mocoss.model.DummyInd;
import org.upsi.eclipselink.mocoss.model.DummyPsytest;
import org.upsi.eclipselink.mocoss.model.DummyRefdet;

public class MoCoSSQuery extends MoCoSSEM{
	private String stringQuery;
	
	//private ResultSet rSet;
	//private PreparedStatement pstatement;
	
	public MoCoSSQuery() {
	}
	
	public List <DummyInd> dummyIndList() {
		MoCoSSEM.startET();
		try {
		stringQuery = "SELECT ind FROM DummyInd ind ORDER BY ind.sessionDate ASC";
		TypedQuery<DummyInd>tQueryInd = em.createQuery(stringQuery, DummyInd.class);
		List<DummyInd> indList = tQueryInd.getResultList();
		return indList;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			MoCoSSEM.closeEM();
		}
		return null;
	}
	
	public List <DummyGrp> dummyGrpList() {
		MoCoSSEM.startET();
		try {
		stringQuery = "SELECT grp FROM DummyGrp grp ORDER BY grp.sessionDate ASC";
		TypedQuery<DummyGrp> tQueryGrp = em.createQuery(stringQuery,DummyGrp.class);
		List<DummyGrp> grpList = tQueryGrp.getResultList();
		return grpList;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MoCoSSEM.closeEM();
		}
		return null;
	}
	
	public List <DummyPsytest> dummyPTList() {
		MoCoSSEM.startET();
		try {
			stringQuery = "SELECT pt FROM DummyPsytest pt ORDER BY pt.psytestDate ASC";
			TypedQuery<DummyPsytest> tQueryPT = em.createQuery(stringQuery, DummyPsytest.class);
			List<DummyPsytest> ptList = tQueryPT.getResultList();
			return ptList;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			MoCoSSEM.closeEM();
		}
		return null;
	}
	
	public List <DummyRefdet> dummyRDList() {
		MoCoSSEM.startET();
		try {
			stringQuery = "SELECT rd FROM DummyRefdet rd ORDER BY rd.referStud ASC";
			TypedQuery<DummyRefdet> tQueryRD = em.createQuery(stringQuery, DummyRefdet.class);
			List<DummyRefdet> rdList = tQueryRD.getResultList();
			return rdList;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			MoCoSSEM.closeEM();
		}
		return null;
	}
	
	public List <DummyConsdet> dummyCDList() {
		MoCoSSEM.startET();
		try {
			stringQuery = "SELECT cd FROM DummyConsdet cd ORDER BY cd.consField ASC";
			TypedQuery<DummyConsdet> tQueryCD = em.createQuery(stringQuery, DummyConsdet.class);
			List<DummyConsdet> cdList = tQueryCD.getResultList();
			return cdList;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			MoCoSSEM.closeEM();
		}
		return null;
	}

}
