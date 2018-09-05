package utm.ais.padimim.EM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.config.PersistenceUnitProperties;

import oracle.jdbc.OraclePreparedStatement;



public abstract class PadimimEM  {
	
	private static  Map<String, Object> properties = new HashMap<String, Object>();
	private static EntityManagerFactory emf = null;
	protected static EntityManager em;
	protected static EntityTransaction et;
	private static Connection conn;
	private static PreparedStatement pstmnt;
	private static OraclePreparedStatement opstatement;
	
	public PadimimEM() {
		
	}
	
	public static  Map<String, Object> init() {
		properties.put(PersistenceUnitProperties.JDBC_DRIVER, "oracle.jdbc.driver.OracleDriver");
		properties.put(PersistenceUnitProperties.JDBC_URL, "jdbc:oracle:thin:@127.0.0.1:1521:SID");
		properties.put(PersistenceUnitProperties.JDBC_USER, "PADIMIMDEV");
		properties.put(PersistenceUnitProperties.JDBC_PASSWORD, "padimimdev");
		
		properties.put(PersistenceUnitProperties.TRANSACTION_TYPE,"RESOURCE_LOCAL");
		properties.put(PersistenceUnitProperties.CLASSLOADER,PadimimEM.class.getClassLoader());
		properties.put(PersistenceUnitProperties.LOGGING_LEVEL, "FINEST");
		properties.put(PersistenceUnitProperties.TARGET_DATABASE, "Oracle11");
		properties.put(PersistenceUnitProperties.TARGET_SERVER, "WebLogic");
		properties.put(PersistenceUnitProperties.WEAVING, "true");
		
		
		System.out.print("init PadimimEM...");
		return properties;
	}
	
	public static EntityManager createEntityManager() {
		if (emf == null)
		//emf = new PersistenceProvider().createEntityManagerFactory("WebServiceMobile",init());
		emf = Persistence.createEntityManagerFactory("padimim_PU",init());
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
	
	public void closeEM() {
		em.close();
	}
	
	public static EntityTransaction startET() {
		et = createEntityManager().getTransaction();
		et.begin();
		return et;
	}
	
	public static Query createQuery(String sql) {
		em = createEntityManager();
		em.getTransaction().begin();
		return em.createQuery(sql);
	}
	
	public static Query createNamedQuery(String sql) {
		em = createEntityManager();
		em.getTransaction().begin();
		return em.createNamedQuery(sql);
	}
		
	public static Query createNativeQuery(String sql) {
		em = createEntityManager();
		em.getTransaction().begin();
		return em.createNativeQuery(sql);
	}
	
	public static Query createNativeQuery(String sql,String resultsetmapping) {
		em = createEntityManager();
		em.getTransaction().begin();
		return em.createNativeQuery(sql, resultsetmapping);
	}
	
	public static Query createNativeQuery(String sql, Class<?> classArg) {
		em = createEntityManager();
		em.getTransaction().begin();
		return em.createNativeQuery(sql, classArg);
	}
	
	public static PreparedStatement prepareStatement(String statement) throws SQLException {
		pstmnt = getConnection().prepareStatement(statement);
		return pstmnt;
	}
	
	public static Connection getConnection() throws SQLException {
		em = createEntityManager();
		em.getTransaction().begin();
			conn = em.unwrap(Connection.class);
		  if (conn == null) {
			  System.out.print("Connection not established"); 
			  conn.close();
		  }
		return conn;	 
	 }
	
	public static OraclePreparedStatement oraclePrepareStatement(String query) throws SQLException {
		opstatement = (OraclePreparedStatement) getConnection().prepareStatement(query);
		return opstatement;
		
	}

}
