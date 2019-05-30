package utm.ais.padimim.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the DeletedFiles database table.
 * 
 */
@Entity
@Table(name="DeletedFiles")
@NamedQuery(name="DeletedFile.findAll", query="SELECT d FROM DeletedFile d")
public class DeletedFile implements Serializable {
	private static final long serialVersionUID = 1L;
	private String compressedHash;
	private BigInteger compressedSize;
	private int compressionType;
	private int fileType;
	private String uncompressedHash;
	private BigInteger uncompressedSize;
	private String uuid;

	public DeletedFile() {
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


	public int getFileType() {
		return this.fileType;
	}

	public void setFileType(int fileType) {
		this.fileType = fileType;
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

}