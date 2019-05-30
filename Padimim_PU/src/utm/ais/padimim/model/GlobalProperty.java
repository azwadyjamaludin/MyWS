package utm.ais.padimim.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GlobalProperties database table.
 * 
 */
@Entity
@Table(name="GlobalProperties")
@NamedQuery(name="GlobalProperty.findAll", query="SELECT g FROM GlobalProperty g")
public class GlobalProperty implements Serializable {
	private static final long serialVersionUID = 1L;
	private int property;
	private String value;

	public GlobalProperty() {
	}


	@Id
	@SequenceGenerator(name="GLOBALPROPERTIES_PROPERTY_GENERATOR", sequenceName="GLOBALPROPERTIES")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GLOBALPROPERTIES_PROPERTY_GENERATOR")
	public int getProperty() {
		return this.property;
	}

	public void setProperty(int property) {
		this.property = property;
	}


	@Lob
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}