package br.com.analistarural.domain.entity.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "fuel_type")
@Entity
public class FuelType implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "id_fuel_type")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "fuel_type_id_fuel_type_seq")
	@SequenceGenerator(name = "fuel_type_id_fuel_type_seq", sequenceName = "fuel_type_id_fuel_type_seq", allocationSize = 1)
	private @Id Long idFuelType;
	
	@Column(name = "name")
	private String name;

	public Long getIdFuelType() {
		return idFuelType;
	}

	public void setIdFuelType(Long idFuelType) {
		this.idFuelType = idFuelType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
