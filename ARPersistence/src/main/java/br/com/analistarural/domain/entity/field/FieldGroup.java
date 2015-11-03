package br.com.analistarural.domain.entity.field;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "field_group")
public @Entity class FieldGroup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "\"idFieldGroup\"")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "\"FieldGroup_idFieldGroup_seq\"")
	@SequenceGenerator(name = "\"FieldGroup_idFieldGroup_seq\"", sequenceName = "\"FieldGroup_idFieldGroup_seq\"", allocationSize = 1)
	private @Id Long id;

	@Column(name = "name", length = 120, nullable = false)
	private String name;

	// @OneToMany(mappedBy = "field")
	// private List<Field> fields;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
