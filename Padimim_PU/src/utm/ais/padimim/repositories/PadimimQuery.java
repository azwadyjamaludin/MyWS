package utm.ais.padimim.repositories;

import java.util.List;

import javax.persistence.TypedQuery;

import utm.ais.padimim.EM.PadimimEM;
import utm.ais.padimim.model.MainDicomTag;
import utm.ais.padimim.model.PatientRecyclingOrder;
import utm.ais.padimim.model.Resource;

public class PadimimQuery extends PadimimEM {
	private String stringQuery;
	private TypedQuery<Resource> tQueryR;
	private TypedQuery<PatientRecyclingOrder> tQueryP;
	private TypedQuery<MainDicomTag> tQueryD;
	
	
	public PadimimQuery() {
	}
	
	
	public List<Resource> getAllResource() {
		PadimimEM.startET();
		try {
			stringQuery = "SELECT r FROM Resource r";
			tQueryR = em.createQuery(stringQuery, Resource.class);
			return tQueryR.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			PadimimEM.closeEM();
		}
		return null;
	}
	
	public List<Resource> getResourceByPIDRange() {
		PadimimEM.startET();
		try {
			stringQuery = "SELECT r FROM Resource r WHERE r.parentId BETWEEN :start AND :end";
			tQueryR = em.createQuery(stringQuery, Resource.class);
			tQueryR.setParameter("start", 1);
			tQueryR.setParameter("end", 2);
			return tQueryR.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			PadimimEM.closeEM();
		}
		return null;
	}
	
	public List<PatientRecyclingOrder> getPatientRecycling() {
		PadimimEM.startET();
		try {
			stringQuery = "SELECT p FROM PatientRecyclingOrder p";
			tQueryP = em.createQuery(stringQuery, PatientRecyclingOrder.class);
			return tQueryP.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			PadimimEM.closeEM();
		}
		return null;
	}
	
	public MainDicomTag getDicomTagPatientName(String id) {
		PadimimEM.startET();
		try {
			stringQuery = "SELECT dt FROM MainDicomTag dt WHERE dt.resource.internalId=:id and dt.id.tagGroup=:tg and dt.id.tagElement=:te and dt.value<>''";
			tQueryD = em.createQuery(stringQuery, MainDicomTag.class);
			tQueryD.setParameter("id", id);
			tQueryD.setParameter("tg", 16);
			tQueryD.setParameter("te", 16);
			return tQueryD.getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			PadimimEM.closeEM();
		}
		return null;
	}
	
	public MainDicomTag getDicomTagPatientID(String id) {
		PadimimEM.startET();
		try {
			stringQuery = "SELECT dt FROM MainDicomTag dt WHERE dt.resource.internalId=:id and dt.id.tagGroup=:tg and dt.id.tagElement=:te and dt.value<>''";
			tQueryD = em.createQuery(stringQuery, MainDicomTag.class);
			tQueryD.setParameter("id", id);
			tQueryD.setParameter("tg", 16);
			tQueryD.setParameter("te", 32);
			return tQueryD.getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			PadimimEM.closeEM();
		}
		return null;
	}
	
	public MainDicomTag getDicomTagDOB(String id) {
		PadimimEM.startET();
		try {
			stringQuery = "SELECT dt FROM MainDicomTag dt WHERE dt.resource.internalId=:id and dt.id.tagGroup=:tg and dt.id.tagElement=:te and dt.value<>''";
			tQueryD = em.createQuery(stringQuery, MainDicomTag.class);
			tQueryD.setParameter("id", id);
			tQueryD.setParameter("tg", 16);
			tQueryD.setParameter("te", 48);
			return tQueryD.getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			PadimimEM.closeEM();
		}
		return null;
	}
	
	public MainDicomTag getDicomTagSex(String id) {
		PadimimEM.startET();
		try {
			stringQuery = "SELECT dt FROM MainDicomTag dt WHERE dt.resource.internalId=:id and dt.id.tagGroup=:tg and dt.id.tagElement=:te and dt.value<>''";
			tQueryD = em.createQuery(stringQuery, MainDicomTag.class);
			tQueryD.setParameter("id", id);
			tQueryD.setParameter("tg", 16);
			tQueryD.setParameter("te", 64);
			return tQueryD.getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			PadimimEM.closeEM();
		}
		return null;
	}

	public MainDicomTag getDicomTagStudyDate(String id) {
		PadimimEM.startET();
		try {
			stringQuery = "SELECT dt FROM MainDicomTag dt WHERE dt.resource.internalId=:id and dt.id.tagGroup=:tg and dt.id.tagElement=:te and dt.value<>''";
			tQueryD = em.createQuery(stringQuery, MainDicomTag.class);
			tQueryD.setParameter("id", id);
			tQueryD.setParameter("tg", 8);
			tQueryD.setParameter("te", 32);
			return tQueryD.getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			PadimimEM.closeEM();
		}
		return null;
	}
	
	public MainDicomTag getDicomTagStudyName(String id) {
		PadimimEM.startET();
		try {
			stringQuery = "SELECT dt FROM MainDicomTag dt WHERE dt.resource.internalId=:id and dt.id.tagGroup=:tg and dt.id.tagElement=:te and dt.value<>''";
			tQueryD = em.createQuery(stringQuery, MainDicomTag.class);
			tQueryD.setParameter("id", id);
			tQueryD.setParameter("tg", 8);
			tQueryD.setParameter("te", 4144);	
			return tQueryD.getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			PadimimEM.closeEM();
		}
		return null;
	}
	
	public MainDicomTag getDicomTagInstitution(String id) {
		PadimimEM.startET();
		try {
			stringQuery = "SELECT dt FROM MainDicomTag dt WHERE dt.resource.internalId=:id and dt.id.tagGroup=:tg and dt.id.tagElement=:te and dt.value<>''";
			tQueryD = em.createQuery(stringQuery, MainDicomTag.class);
			tQueryD.setParameter("id", id);
			tQueryD.setParameter("tg", 8);
			tQueryD.setParameter("te", 128);
			return tQueryD.getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			PadimimEM.closeEM();
		}
		return null;
	}
	
	public MainDicomTag getDicomTagAccessNum(String id) {
		PadimimEM.startET();
		try {
			stringQuery = "SELECT dt FROM MainDicomTag dt WHERE dt.resource.internalId=:id and dt.id.tagGroup=:tg and dt.id.tagElement=:te and dt.value<>''";
			tQueryD = em.createQuery(stringQuery, MainDicomTag.class);
			tQueryD.setParameter("id", id);
			tQueryD.setParameter("tg", 8);
			tQueryD.setParameter("te", 80);
			return tQueryD.getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			PadimimEM.closeEM();
		}
		return null;
	}

}
