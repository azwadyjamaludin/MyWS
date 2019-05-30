package utm.ais.padimim.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the GlobalIntegers database table.
 * 
 */
@Entity
@Table(name="GlobalIntegers")
@NamedQuery(name="GlobalInteger.findAll", query="SELECT g FROM GlobalInteger g")
public class GlobalInteger implements Serializable {
	private static final long serialVersionUID = 1L;
	private int property;
	private BigInteger value;

	public GlobalInteger() {
	}


	@Id
	@SequenceGenerator(name="GLOBALINTEGERS_PROPERTY_GENERATOR", sequenceName="GLOBALINTEGERS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GLOBALINTEGERS_PROPERTY_GENERATOR")
	public int getProperty() {
		return this.property;
	}

	public void setProperty(int property) {
		this.property = property;
	}


	public BigInteger getValue() {
		return this.value;
	}

	public void setValue(BigInteger value) {
		this.value = value;
	}

}