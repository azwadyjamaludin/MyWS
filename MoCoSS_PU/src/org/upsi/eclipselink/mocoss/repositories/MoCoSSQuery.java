package org.upsi.eclipselink.mocoss.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.upsi.eclipselink.mocoss.em.MoCoSSEM;

public class MoCoSSQuery{
	private ResultSet rSet;
	private String stringQuery;
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

}
