package org.upsi.eclipselink.mocoss.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.TypedQuery;

import org.upsi.eclipselink.mocoss.em.MoCoSSEM;
import org.upsi.eclipselink.mocoss.model.Dummy_GrpCoun;
import org.upsi.eclipselink.mocoss.model.Dummy_IndCoun;

public class MoCoSSQuery extends MoCoSSEM{
	private String stringQuery;
	
	private ResultSet rSet;
	private PreparedStatement pstatement;
	
	public MoCoSSQuery() {
	}
	
	public ResultSet dummyIndCoun() throws SQLException {
		stringQuery = "SELECT session_date, session_num, client_code, session_hour_start, session_hour_end FROM \"dummy_IndCoun\" ORDER BY session_date";
		pstatement = MoCoSSEM.prepareStatement(stringQuery);
		rSet = pstatement.executeQuery();
		return rSet;
	}
	
	public ResultSet dummyGrpCoun() throws SQLException {
		stringQuery = "SELECT session_date, session_num, client_group_code, session_hour_start, session_hour_end FROM \"dummy_GrpCoun\" ORDER BY session_date";
		pstatement = MoCoSSEM.prepareStatement(stringQuery);
		rSet = pstatement.executeQuery();
		return rSet;
	}
	
	public List <Dummy_IndCoun> dummyIndList() {
		MoCoSSEM.startET();
		try {
		stringQuery = "SELECT ind FROM Dummy_IndCoun ind ORDER BY ind.sessionDate ASC";
		TypedQuery<Dummy_IndCoun>tQueryInd = em.createQuery(stringQuery, Dummy_IndCoun.class);
		List<Dummy_IndCoun> indList = tQueryInd.getResultList();
		return indList;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			MoCoSSEM.closeEM();
		}
		return null;
	}
	
	public List <Dummy_GrpCoun> dummyGrpList() {
		MoCoSSEM.startET();
		try {
		stringQuery = "SELECT grp FROM Dummy_GrpCoun grp ORDER BY grp.sessionDate ASC";
		TypedQuery<Dummy_GrpCoun> tQueryGrp = em.createQuery(stringQuery,Dummy_GrpCoun.class);
		List<Dummy_GrpCoun> grpList = tQueryGrp.getResultList();
		return grpList;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MoCoSSEM.closeEM();
		}
		return null;
	}

}
