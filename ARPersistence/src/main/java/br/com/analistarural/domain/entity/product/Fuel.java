package br.com.analistarural.domain.entity.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "fuel")
public class Fuel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_fuel")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "fuel_id_fuel_seq")
	@SequenceGenerator(name = "fuel_id_fuel_seq", sequenceName = "fuel_id_fuel_seq", allocationSize = 1)
	private @Id Long idFuel;
	
	@Column(name = "code_anp")
	private String codeANP;
	
	@Column(name = "description_anp")
	private String descriptionANP;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_consumption", nullable = false)
	private Consumption consumption;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_fuel_type", nullable = false)
	private FuelType fuelType;

	public Long getIdFuel() {
		return idFuel;
	}

	public void setIdFuel(Long idFuel) {
		this.idFuel = idFuel;
	}

	public String getCodeANP() {
		return codeANP;
	}

	public void setCodeANP(String codeANP) {
		this.codeANP = codeANP;
	}

	public String getDescriptionANP() {
		return descriptionANP;
	}

	public void setDescriptionANP(String descriptionANP) {
		this.descriptionANP = descriptionANP;
	}

	public Consumption getConsumption() {
		return consumption;
	}

	public void setConsumption(Consumption consumption) {
		this.consumption = consumption;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}
	
	

	
}
