package utm.ais.padimim.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import utm.ais.padimim.EM.PadimimEM;
import utm.ais.padimim.model.MedicalImageTable;
import utm.ais.padimim.model.PatientData;


public class PadimimQuery extends PadimimEM implements PadimimInterface{

	private PreparedStatement pstatement;
	private ResultSet rSet;
	private String stringQuery;
		
	public PadimimQuery() {
		
	}
	
	public List<String> testMedicalImageTableController() {
		List<String> test = new ArrayList<String>();
		test.add("testing");
		test.add("PADI_MIM");
		test.add("WebService");
		return test;
	}
	
	public List<PatientData> getPatientNameAndModality() {
		PadimimEM.startET();
		stringQuery = "SELECT pd FROM PatientData pd ORDER by pd.patientName";
		TypedQuery<PatientData> typequery = em.createQuery(stringQuery,PatientData.class);
			List<PatientData> pds = typequery.getResultList();
		
		return pds;
	}
	
	public List<MedicalImageTable> getImageListByPatientName(String patientName) {
		PadimimEM.startET();
		stringQuery = "SELECT mit FROM MedicalImageTable mit WHERE mit.patientName = :patientName";
		TypedQuery<MedicalImageTable> typedquery = em.createQuery(stringQuery,MedicalImageTable.class);
		typedquery.setParameter("patientName", patientName);  
		List<MedicalImageTable> mits = typedquery.getResultList();
				
		return mits;
	}
	
	public ResultSet  getPatientNameAndModalitySet() throws SQLException {
		stringQuery = "select PATIENT_NAME, MODALITY from PATIENT_DATA ";
		pstatement = PadimimQuery.prepareStatement(stringQuery);
		
		rSet = pstatement.executeQuery();
		return rSet;
	}
	
	public ResultSet  getPatientNameAndModalitySet2(String patientName) throws SQLException {
		stringQuery = "select PATIENT_NAME, MODALITY from PATIENT_DATA where PATIENT_NAME = ? ";
		pstatement = PadimimQuery.prepareStatement(stringQuery);
		pstatement.setString(1, patientName);
		rSet = pstatement.executeQuery();
		return rSet;
	}
	
	public OracleResultSet getImageListByPatientNameSet(String patientName) throws SQLException {
		OracleResultSet oRSet;
		stringQuery = "Select IMG_FILENAME, IMAGE from MEDICAL_IMAGE_TABLE where PATIENT_NAME = ?";
		OraclePreparedStatement opstmnt = PadimimQuery.oraclePrepareStatement(stringQuery);
		opstmnt.setString(1, patientName);  
		oRSet = (OracleResultSet) opstmnt.executeQuery();
				
		return oRSet;
	}
}
