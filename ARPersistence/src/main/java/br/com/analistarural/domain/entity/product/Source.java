package br.com.analistarural.domain.entity.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "source")
public @Entity class Source implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "\"idSource\"")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "\"source_idSource_seq\"")
	@SequenceGenerator(name = "\"source_idSource_seq\"", sequenceName = "\"source_idSource_seq\"", allocationSize = 1)
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
