package utm.ais.padimim.repositories;

import java.util.List;

import utm.ais.padimim.model.PatientData;

public interface PadimimInterface {
	List<String> testMedicalImageTableController();
	List<PatientData> getPatientNameAndModality();
	
}
