package utm.ais.padimim.repositories;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.TypedQuery;

import utm.ais.padimim.EM.PadimimImageEM;
import utm.ais.padimim.model.AttachedFile;
import utm.ais.padimim.model.Resource;
import utm.ais.padimim.model.StorageArea;

public class PadimimImage extends PadimimImageEM {
	private String stringQuery;
	private TypedQuery<Resource> tQueryR;
	private TypedQuery<AttachedFile> tQueryA;
	private TypedQuery<StorageArea> tQueryS;
	
	public List<Resource> getResourceByParent(BigInteger parentID) {
		PadimimImageEM.startET();
		try {
			stringQuery = "SELECT r FROM Resource r WHERE r.parentId=:parent";
			tQueryR = em.createQuery(stringQuery, Resource.class);
			tQueryR.setParameter("parent", parentID);
			return tQueryR.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			PadimimImageEM.closeEM();
		}
		return null;
	}
	
	public List<AttachedFile> getAttachFileType1(String id) {
		PadimimImageEM.startET();
		try {
			stringQuery = "SELECT af FROM AttachedFile af WHERE af.resource.internalId=:id and af.id.fileType=:type";
			tQueryA = em.createQuery(stringQuery, AttachedFile.class);
			tQueryA.setParameter("id", id);
			tQueryA.setParameter("type", 1);
			return tQueryA.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			PadimimImageEM.closeEM();
		}
		return null;
	}
	

	public StorageArea getSingleDataType1(String uuid) {
		PadimimImageEM.startET();
		try {
			stringQuery = "SELECT sa FROM StorageArea sa WHERE sa.uuid=:uuid";
			tQueryS = em.createQuery(stringQuery, StorageArea.class);
			tQueryS.setParameter("uuid", uuid);
			return tQueryS.getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			PadimimImageEM.closeEM();
		}
		return null;
	}
}
