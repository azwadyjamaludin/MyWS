package org.azwady.jaxrs.resources;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import utm.ais.padimim.model.AttachedFile;
import utm.ais.padimim.model.MainDicomTag;
import utm.ais.padimim.model.PatientRecyclingOrder;
import utm.ais.padimim.model.Resource;
import utm.ais.padimim.model.StorageArea;
import utm.ais.padimim.repositories.DicomImage;
import utm.ais.padimim.repositories.DicomTag;
import utm.ais.padimim.repositories.DicomTagL2;
import utm.ais.padimim.repositories.PadimimImage;
import utm.ais.padimim.repositories.PadimimQuery;

@Path("/padimim")
public class PadimimController {
	
	private JSONObject jsonObject = new JSONObject();
	private PadimimQuery pmQuery = new PadimimQuery();
	private PadimimImage pmImage = new PadimimImage();
	private List<PatientRecyclingOrder> pRO = new ArrayList<PatientRecyclingOrder>();
	private List<Resource> rsImage = new ArrayList<Resource>();
	private List<AttachedFile> atFile = new ArrayList<AttachedFile>();
	private List<DicomImage> data = new ArrayList<DicomImage>();
	private List<DicomTag> tag = new ArrayList<DicomTag>();
	private List<DicomTagL2> tagL2 = new ArrayList<DicomTagL2>();
	private StorageArea sa = new StorageArea();
	private MainDicomTag mdt = new MainDicomTag();
	
	public PadimimController() {

	}
	
	@GET
	@Path("/initiate")
	@Produces("application/json")
	public Response initiate() {
		jsonObject.put("init", "PadimimController");
		return Response.status(200).entity(jsonObject.toString()).build();
	}
	
	@GET
	@Path("/getContent")
	@Produces("application/json")
	public Response getContent(@QueryParam("id")String id) throws JSONException, MalformedURLException {
		BigInteger parentID = new BigInteger(id);
		BigInteger addBI = new BigInteger("1");
		BigInteger newPID = parentID.add(addBI);
		
		rsImage = pmImage.getResourceByParent(newPID);
		jsonObject.put("dicomImage",getData(rsImage));
		
		return Response.status(200).entity(jsonObject.toString(4)).build();
	}
	
	@GET
	@Path("/getTag")
	@Produces("application/json")
	public Response getTag() {
		pRO = pmQuery.getPatientRecycling();
		jsonObject.put("dicomTag", getTags(pRO));
		
		return Response.status(200).entity(jsonObject.toString(4)).build();
	}
	
	@GET
	@Path("/getTagL2")
	@Produces("application/json")
	public Response getTagLevel2(@QueryParam("id")String id) {
		BigInteger parentID = new BigInteger(id);
		BigInteger addBI = new BigInteger("1");
		BigInteger newPID = parentID.add(addBI);
		String newStringPID = newPID.toString();
		
		jsonObject.put("dicomTagL2", getTagsL2(newStringPID));
		
		return Response.status(200).entity(jsonObject.toString(4)).build();
	}
	
	public List<DicomTag> getTags(List<PatientRecyclingOrder> orders) {
		String patientName = "";
		String patientID = "";
		String id = "";
		
		for (PatientRecyclingOrder order:orders) {
			mdt = pmQuery.getDicomTagPatientName(order.getResource().getInternalId());
			if (mdt == null) {
				patientName = "";
				} else {
					patientName = mdt.getValue();
				}
			mdt = pmQuery.getDicomTagPatientID(order.getResource().getInternalId());
			if (mdt == null) {
				patientID = "";
				} else {
					patientID = mdt.getValue();
				}	
			id = order.getResource().getInternalId();
			tag.add(new DicomTag(patientName,patientID,id));
		}
		return tag;
	}
	
public List<DicomTagL2> getTagsL2(String newStringPID) {
	String patientName = "";
	String patientID = "";
	String DOB = "";
	String sex = "";
	String studyDate = "";
	String studyName = "";
	String institution = "";
	String accessNumber = "";
	String id = "";
	
			mdt = pmQuery.getDicomTagPatientName(newStringPID);
			if (mdt == null) {
				patientName = "";
				} else {
					patientName = mdt.getValue();
				}
			mdt = pmQuery.getDicomTagPatientID(newStringPID);
			if (mdt == null) {
				patientID = "";
				} else {
					patientID = mdt.getValue();
				}
			mdt = pmQuery.getDicomTagDOB(newStringPID);
			if (mdt == null) {
				DOB = "";
				} else {
					DOB = mdt.getValue();
				}
			mdt = pmQuery.getDicomTagSex(newStringPID);
			if (mdt == null) {
				sex = "";
				} else {
					sex = mdt.getValue();
				}
			mdt = pmQuery.getDicomTagStudyDate(newStringPID);
			if (mdt == null) {
				studyDate = "";
				} else {
					studyDate = mdt.getValue();
				}
			mdt = pmQuery.getDicomTagStudyName(newStringPID);
			if (mdt == null) {
				studyName = "";
				} else {
					studyName = mdt.getValue();
				}
			mdt = pmQuery.getDicomTagInstitution(newStringPID);
				if (mdt == null) {
				institution = "";
				} else {
					institution = mdt.getValue();
				}
			mdt = pmQuery.getDicomTagAccessNum(newStringPID);
			if (mdt == null) {
				accessNumber = "";
				} else {
					accessNumber = mdt.getValue();
				}
			id = newStringPID;
			tagL2.add(new DicomTagL2(patientName,patientID,DOB,sex,studyDate,studyName,institution,accessNumber,id));
		return tagL2;
	}
		
	protected List<DicomImage> getData(List<Resource> rs) throws MalformedURLException {
		String uuid = "";
		String path = "";
		URL url = new URL("https://macbookpro.my/assets/DICOMholder/");
		
		for (Resource r : rs) {
			atFile = pmImage.getAttachFileType1(r.getInternalId());
			StorageArea saImage = getImage(atFile,sa);
			path = System.getProperty("user.home")+"/Sites/assets/DICOMholder/";
			uuid = saImage.getUuid();
			try {
				createFileAndWriteByte(path,uuid,saImage.getContent());
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			data.add(new DicomImage(uuid,url+uuid+".dcm"));
		}
		return data;
	}
	
	protected StorageArea getImage (List<AttachedFile> files, StorageArea sa) {
		for (AttachedFile af:files) {
		sa = pmImage.getSingleDataType1(af.getUuid());
		}
		return sa; 
	}
	
	protected void createFileAndWriteByte(String generatedPath, String filename, byte[] byteArray) throws IOException {
		File outputfile = new File(generatedPath+filename+".dcm");
		if (!outputfile.exists()) {
		outputfile.createNewFile();
		outputfile.setReadable(true, false);
		outputfile.setWritable(true, false);
		
		FileOutputStream fos = new FileOutputStream(outputfile);
		fos.write(byteArray);
		fos.close();
		
		
		}
		else if (outputfile.exists()) {
			  outputfile.delete();
			  outputfile.createNewFile();
			  outputfile.setReadable(true, false);
			  outputfile.setWritable(true, false);
			
			  FileOutputStream fos = new FileOutputStream(outputfile);
				fos.write(byteArray);
				fos.close();
		  }
	 }

}


