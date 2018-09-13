package org.azwady.jaxrs.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

@Path("/padimim")
public class PadimimController {
	
	private JSONObject jsonObject = new JSONObject();
	/*private JSONArray jArray = new JSONArray();
	private ResultSet rSet;
	private PadimimController mitc = new PadimimController();
	private DicomFileUpload upload = new DicomFileUpload();*/
	
	public PadimimController() {

	}
	
	@GET
	@Path("/initiate")
	@Produces("application/json")
	public Response initiate() {
		jsonObject.put("init", "PadimimController");
		return Response.status(200).entity(jsonObject.toString()).build();
	}
	
	/*@GET
	@Path("/testClient")
	@Produces("application/json") 
	public Response test() {
		List<String> clientTest = mitc.testMedicalImageTableController();
		jsonObject.put("clientTest",clientTest);
		return Response.status(200).entity(jsonObject.toString()).build();
	}
	
	@GET
	@Path("/getPatientNameAndModality")
	@Produces("application/json") 
	public Response getPatientNameAndModality() throws SQLException {
		List<PatientData> pds = mitc.getPatientNameAndModality();
		for(PatientData pd : pds){
			jsonObject.put("patientName", pd.getPatientName());
			jsonObject.put("modality", pd.getModality());
			}
		
		return Response.status(200).entity(jsonObject.toString()).build();
	}
	
	@GET
	@Path("/getImage")
	@Produces("application/json") 
	public Response getImageList(@QueryParam("patientName")String patientName) throws SQLException, IOException {
		
		String patientNameNew =  patientName.replace("%20","");
		//List<PatientImage> pis = new ArrayList<PatientImage>();
		OracleResultSet oRSet = mitc.getImageListByPatientNameSet(patientNameNew);
		
		while(oRSet.next()) {
			String path = context.getRealPath("/")+"images/dicomImage";
			String newFileName = oRSet.getString("IMG_FILENAME").replace("dcm", "jpeg");
			jsonObject.put("filename", newFileName);
			jArray.put(path+"/"+newFileName);
			jsonObject.put("filePath", jArray);
			
			OrdImage image = (OrdImage) oRSet.getORAData(1, OrdImage.getORADataFactory());
			byte[] imgByte = image.getDataInByteArray();
			createFileAndWriteByte(path,newFileName,imgByte);
			}
			
		return Response.status(200).entity(jsonObject.toString()).build();
	}
	
	@POST
	@Path("/UploadDicom")
	@Consumes("multipart/form-data")
	public void UploadDicom(InputStream filepaths) throws IOException {
		StringBuilder sb = new StringBuilder();
		  
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(filepaths));
			String line;
			while ((line = in.readLine()) != null) {
				sb.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
			}
		
		JSONArray jArray = new JSONArray(sb.toString());
		System.out.println(jArray);
		/*Iterator<Object> iter = jArray.iterator();
		
		while (iter.hasNext()) {
			URI newfilepathURI = URI.create(iter.toString());
			File newfile = new File(newfilepathURI);
			String filename = newfile.getName();
			uploadDCM(filename, newfile);
		}
	  }	
	
	
	protected void uploadDCM(String filename, File newfile) throws IOException {
		upload.uploadFile(filename, newfile);
		upload.save();
	}
	
	public void createFileAndWriteByte(String generatedPath, String filename, byte[] byteArray) throws IOException {
		File outputfile = new File(generatedPath+"/"+filename);
		if (!outputfile.exists()) {
		outputfile.createNewFile();
		
		InputStream in = new ByteArrayInputStream(byteArray);
		BufferedImage byteDataImage = ImageIO.read(in);
		
		ImageIO.write(byteDataImage, "jpeg", outputfile);
		}
		else if (outputfile.exists()) {
			  outputfile.delete();
			  outputfile.createNewFile();
			
			  InputStream in = new ByteArrayInputStream(byteArray);
			  BufferedImage byteDataImage = ImageIO.read(in);
				
			  ImageIO.write(byteDataImage, "jpeg", outputfile);
		  }
	 }*/
}


