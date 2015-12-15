package br.com.analistarural.domain.entity.report;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "element_type")
public @Entity class ElementType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "element_type_element_type_id_seq")
	@SequenceGenerator(name = "element_type_element_type_id_seq", sequenceName = "element_type_element_type_id_seq", allocationSize = 1)
	@Column(name = "element_type_id")
	private Long id;

	@Column(name = "description", length = 60, nullable = false, unique = true)
	private String description;
	
	@Column(name = "default_value")
	private Long defaultValue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(Long defaultValue) {
		this.defaultValue = defaultValue;
	}

}
