package utm.ais.padimim.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the AttachedFiles database table.
 * 
 */
@Entity
@Table(name="AttachedFiles")
@NamedQuery(name="AttachedFile.findAll", query="SELECT a FROM AttachedFile a")
public class AttachedFile implements Serializable {
	private static final long serialVersionUID = 1L;
	private AttachedFilePK id;
	private String compressedHash;
	private BigInteger compressedSize;
	private int compressionType;
	private String uncompressedHash;
	private BigInteger uncompressedSize;
	private String uuid;
	private Resource resource;

	public AttachedFile() {
	}


	@EmbeddedId
	public AttachedFilePK getId() {
		return this.id;
	}

	public void setId(AttachedFilePK id) {
		this.id = id;
	}


	public String getCompressedHash() {
		return this.compressedHash;
	}

	public void setCompressedHash(String compressedHash) {
		this.compressedHash = compressedHash;
	}


	public BigInteger getCompressedSize() {
		return this.compressedSize;
	}

	public void setCompressedSize(BigInteger compressedSize) {
		this.compressedSize = compressedSize;
	}


	public int getCompressionType() {
		return this.compressionType;
	}

	public void setCompressionType(int compressionType) {
		this.compressionType = compressionType;
	}


	public String getUncompressedHash() {
		return this.uncompressedHash;
	}

	public void setUncompressedHash(String uncompressedHash) {
		this.uncompressedHash = uncompressedHash;
	}


	public BigInteger getUncompressedSize() {
		return this.uncompressedSize;
	}

	public void setUncompressedSize(BigInteger uncompressedSize) {
		this.uncompressedSize = uncompressedSize;
	}


	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	//bi-directional many-to-one association to Resource
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	public Resource getResource() {
		return this.resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

}