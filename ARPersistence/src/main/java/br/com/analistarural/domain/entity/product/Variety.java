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
	
	@Column(name = "\"idVariety\"")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "\"variety_idVariety_seq\"")
	@SequenceGenerator(name = "\"variety_idVariety_seq\"", sequenceName = "\"variety_idVariety_seq\"", allocationSize = 1)
	private @Id Long id;
	
	@Column(name = "name", length = 120, nullable = false, unique = true)
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id){
		this.id = id;
		
	}


}
