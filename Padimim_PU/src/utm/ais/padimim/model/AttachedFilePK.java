package utm.ais.padimim.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the AttachedFiles database table.
 * 
 */
@Embeddable
public class AttachedFilePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String id;
	private int fileType;

	public AttachedFilePK() {
	}

	@Column(insertable=false, updatable=false)
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public int getFileType() {
		return this.fileType;
	}
	public void setFileType(int fileType) {
		this.fileType = fileType;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AttachedFilePK)) {
			return false;
		}
		AttachedFilePK castOther = (AttachedFilePK)other;
		return 
			this.id.equals(castOther.id)
			&& (this.fileType == castOther.fileType);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id.hashCode();
		hash = hash * prime + this.fileType;
		
		return hash;
	}
}