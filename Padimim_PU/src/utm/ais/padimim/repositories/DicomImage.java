package utm.ais.padimim.repositories;

/**
 * Dicom data model
 */
public class DicomImage {
	private String url;
	private String uuid;
	private String className;
	
	public DicomImage(String uuid, String url) {
		this.className = "DicomImage";
		this.uuid = uuid;
		this.url = url;
	}
	
	

	public String getUrl() {
		return url;
	}

	public String getUuid() {
		return uuid;
	}

	public String getClassName() {
		return className;
	}

}
