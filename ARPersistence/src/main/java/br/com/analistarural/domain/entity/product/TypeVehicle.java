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
@Table(name = "type_vehicle")
public class TypeVehicle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_type_vehicle")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "type_vehicle_id_type_vehicle_seq")
    @SequenceGenerator(name = "type_vehicle_id_type_vehicle_seq", sequenceName = "type_vehicle_id_type_vehicle_seq", allocationSize = 1, initialValue = 1)
	@Id
	private Long idTypeVehicle;
	
	@Column(length = 120, nullable = false)
	private String name;

	public Long getIdTypeVehicle() {
		return idTypeVehicle;
	}

	public void setIdTypeVehicle(Long idTypeVehicle) {
		this.idTypeVehicle = idTypeVehicle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
