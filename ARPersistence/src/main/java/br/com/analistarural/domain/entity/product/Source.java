package br.com.analistarural.domain.entity.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Table(name = "source")
public @Entity class Source implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_source")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "source_id_source_seq")
	@SequenceGenerator(name = "source_id_source_seq", sequenceName = "source_id_source_seq", allocationSize = 1)
	private @Id Long id;
	
	@Column(name = "name", length = 120, nullable = false, unique = true)
	@NotNull(message = "{error.name.notnull}")
    @NotEmpty(message = "{error.name.notEmpty}")
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
