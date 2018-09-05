package utm.ais.padimim.repositories;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.persistence.Query;

import utm.ais.padimim.EM.PadimimEM;

public class DicomFileUpload extends PadimimEM implements DicomInterface {
   
     private Query insertQuery, updateQuery;
     
	public DicomFileUpload() {
	}
	
	public void uploadFile(String filename, File newfile) throws IOException {
		byte[] dicomByte = getFileContent(newfile);
		String stringSQLUpdate = "update UPLOAD_DICOM set UPLOAD_FILENAME = ?, UPLOAD_FILE = ?";
		String stringSQLInsert = "insert into UPLOAD_DICOM (UPLOAD_FILENAME, UPLOAD_FILE) values (?,?)";
		
		updateQuery = DicomFileUpload.createNativeQuery(stringSQLUpdate);
		updateQuery.setParameter(1, filename);
		updateQuery.setParameter(2, dicomByte);
		int result = updateQuery.executeUpdate();
		
		if(result == 0) {
			insertQuery = DicomFileUpload.createNativeQuery(stringSQLInsert);
			insertQuery.setParameter(1, filename);
			insertQuery.setParameter(2, dicomByte);
			insertQuery.executeUpdate();
		}
	}
	
	protected byte[] getFileContent(File newfile) throws IOException {
	
		FileInputStream input = new FileInputStream(newfile);
		ByteArrayOutputStream uploadByte = new ByteArrayOutputStream();
		
		byte[] buf = new byte[1024];
		int len;
		while((len = input.read(buf)) > 0) {
			uploadByte.write(buf, 0, len);
		}
		uploadByte.flush();
		input.close();
		uploadByte.close();
		return uploadByte.toByteArray();
		
	}

}
