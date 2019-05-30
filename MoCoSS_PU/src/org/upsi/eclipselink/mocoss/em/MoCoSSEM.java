package org.upsi.eclipselink.mocoss.em;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.jpa.PersistenceProvider;

public abstract class MoCoSSEM {
	private static  Map<String, Object> properties = new HashMap<String, Object>();
	private static EntityManagerFactory emf = null;
	protected static EntityManager em;
	protected static EntityTransaction et;
	private static Connection conn;
	private static Statement statement;
	private static PreparedStatement pstmnt;
	
	public MoCoSSEM() {
		
	}
	
	public static  Map<String, Object> init() {
		properties.put(PersistenceUnitProperties.JDBC_DRIVER, "com.mysql.jdbc.Driver");
		properties.put(PersistenceUnitProperties.JDBC_URL, "jdbc:mysql://localhost:3306/mocoss");
		properties.put(PersistenceUnitProperties.JDBC_USER, "root");
		properties.put(PersistenceUnitProperties.JDBC_PASSWORD, "asw135091");
		
		properties.put(PersistenceUnitProperties.TRANSACTION_TYPE,"RESOURCE_LOCAL");
		properties.put(PersistenceUnitProperties.CLASSLOADER,MoCoSSEM.class.getClassLoader());
		properties.put(PersistenceUnitProperties.LOGGING_LEVEL, "FINEST");
		properties.put(PersistenceUnitProperties.TARGET_DATABASE, "MySQL");
		properties.put(PersistenceUnitProperties.WEAVING, "true");
		
		System.out.print("init MoCoSSEM...");
		return properties;
	}
	
	public static EntityManager createEntityManager() {
		if (emf == null) {
			emf = new PersistenceProvider().createEntityManagerFactory("MoCoSS_PU",init());
		}
		 em = emf.createEntityManager();
		return em;
	}
	
	public void updateEntities(Object argv) {
		em.merge(argv);
	}
	
	public void save() {
		et = createEntityManager().getTransaction();
		et.begin();
		et.commit();
	}
	
	public static void closeEM() {
		em.close();
	}
	
	public static EntityTransaction startET() {
		et = createEntityManager().getTransaction();
		et.begin();
		return et;
	}
	
	public static Query createQuery(String sql) {
		startET();
		return em.createQuery(sql);
	}
	
	public static Query createNamedQuery(String sql) {
		startET();
		return em.createNamedQuery(sql);
	}
		
	public static Query createNativeQuery(String sql) {
		startET();
		return em.createNativeQuery(sql);
	}
	
	public static Query createNativeQuery(String sql,String resultsetmapping) {
		startET();
		return em.createNativeQuery(sql, resultsetmapping);
	}
	
	public static Query createNativeQuery(String sql, Class<?> classArg) {
		startET();
		return em.createNativeQuery(sql, classArg);
	}
	
	public static TypedQuery<?> createQuery(String sql, Class<?> classArg) {
		startET();
		return em.createQuery(sql, classArg);
	}
	
	public static Connection getConnection() throws SQLException {
		startET();
			conn = em.unwrap(Connection.class);
		  if (conn == null) {
			  System.out.print("Connection not established"); 
			  conn.close();
		  }
		return conn;	 
	 }
	
	public static PreparedStatement prepareStatement(String querystatement) throws SQLException {
		pstmnt = getConnection().prepareStatement(querystatement);
		return pstmnt;
	}
	
	public static Statement queryStatement() throws SQLException {
		 statement = getConnection().createStatement();
		 return statement;
	}

}
