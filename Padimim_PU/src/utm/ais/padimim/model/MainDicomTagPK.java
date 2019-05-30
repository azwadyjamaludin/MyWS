package utm.ais.padimim.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MainDicomTags database table.
 * 
 */
@Embeddable
public class MainDicomTagPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String id;
	private int tagGroup;
	private int tagElement;

	public MainDicomTagPK() {
	}

	@Column(insertable=false, updatable=false)
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public int getTagGroup() {
		return this.tagGroup;
	}
	public void setTagGroup(int tagGroup) {
		this.tagGroup = tagGroup;
	}

	public int getTagElement() {
		return this.tagElement;
	}
	public void setTagElement(int tagElement) {
		this.tagElement = tagElement;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MainDicomTagPK)) {
			return false;
		}
		MainDicomTagPK castOther = (MainDicomTagPK)other;
		return 
			this.id.equals(castOther.id)
			&& (this.tagGroup == castOther.tagGroup)
			&& (this.tagElement == castOther.tagElement);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id.hashCode();
		hash = hash * prime + this.tagGroup;
		hash = hash * prime + this.tagElement;
		
		return hash;
	}
}