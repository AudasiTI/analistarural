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
@Table(name = "variety")
public class Variety implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_variety")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "variety_id_variety_seq")
	@SequenceGenerator(name = "variety_id_variety_seq", sequenceName = "variety_id_variety_seq", allocationSize = 1)
	private @Id Long idVariety;
	
	@Column(name = "name", length = 120, nullable = false, unique = true)
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getIdVariety() {
		return idVariety;
	}
	public void setIdVariety(Long idVariety){
		this.idVariety = idVariety;
		
	}


}
