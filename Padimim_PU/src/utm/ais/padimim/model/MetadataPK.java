package utm.ais.padimim.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the Metadata database table.
 * 
 */
@Embeddable
public class MetadataPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String id;
	private int type;

	public MetadataPK() {
	}

	@Column(insertable=false, updatable=false)
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public int getType() {
		return this.type;
	}
	public void setType(int type) {
		this.type = type;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MetadataPK)) {
			return false;
		}
		MetadataPK castOther = (MetadataPK)other;
		return 
			this.id.equals(castOther.id)
			&& (this.type == castOther.type);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id.hashCode();
		hash = hash * prime + this.type;
		
		return hash;
	}
}