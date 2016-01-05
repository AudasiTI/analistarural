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
@Table(name = "vehicle")
public class Vehicle implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "id_vehicle")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "vehicle_id_vehicle_seq")
    @SequenceGenerator(name = "vehicle_id_vehicle_seq", sequenceName = "vehicle_id_vehicle_seq", allocationSize = 1, initialValue = 1)
	@Id
	private Long idVehicle;
	
	@Column(length = 120, nullable = false)
	private String model;
	
	@Column(length = 120, nullable = false)
	private String brand;
	
	@Column(length = 120, nullable = false)
	private String year;
	
	@Column(name = "acquisition_date", length = 120, nullable = false)
	private String acquisitionDate;
	
	@Column(name="value_hour",length = 120, nullable = false)
	private Double valueHour;
	
	@Column(length = 120, nullable = false)
	private String sign;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_assets", nullable = false)
	private Assets assets;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_type_vehicle", nullable = false)
	private TypeVehicle typeVehicle;

	public Long getIdVehicle() {
		return idVehicle;
	}

	public void setIdVehicle(Long idVehicle) {
		this.idVehicle = idVehicle;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getAcquisitionDate() {
		return acquisitionDate;
	}

	public void setAcquisitionDate(String acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}

	public Double getValueHour() {
		return valueHour;
	}

	public void setValueHour(Double valueHour) {
		this.valueHour = valueHour;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Assets getAssets() {
		return assets;
	}

	public void setAssets(Assets assets) {
		this.assets = assets;
	}

	public TypeVehicle getTypeVehicle() {
		return typeVehicle;
	}

	public void setTypeVehicle(TypeVehicle typeVehicle) {
		this.typeVehicle = typeVehicle;
	}
	
	

}
