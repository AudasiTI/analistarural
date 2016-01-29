package br.com.analistarural.domain.entity.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "measurement")
public class Measurement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "id_measurement")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "measurement_id_measurement_seq")
    @SequenceGenerator(name = "measurement_id_measurement_seq", sequenceName = "measurement_id_measurement_seq", allocationSize = 1, initialValue = 1)
	@Id
	private Long idMeasurement;

	@Column(length = 120, nullable = false)
	private String name;
	
	@Column(length = 120, nullable = false)
	private String abbreviation;

	public Long getIdMeasurement() {
		return idMeasurement;
	}

	public void setIdMeasurement(Long idMeasurement) {
		this.idMeasurement = idMeasurement;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	
}
