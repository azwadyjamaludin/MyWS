package utm.ais.padimim.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the StorageArea database table.
 * 
 */
@Entity
@NamedQuery(name="StorageArea.findAll", query="SELECT s FROM StorageArea s")
public class StorageArea implements Serializable {
	private static final long serialVersionUID = 1L;
	private String uuid;
	private byte[] content;
	private int type;

	public StorageArea() {
	}


	@Id
	@SequenceGenerator(name="STORAGEAREA_UUID_GENERATOR", sequenceName="STORAGEAREA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STORAGEAREA_UUID_GENERATOR")
	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	@Lob
	public byte[] getContent() {
		return this.content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}


	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

}