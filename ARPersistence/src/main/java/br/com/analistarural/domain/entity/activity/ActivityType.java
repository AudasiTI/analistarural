package br.com.analistarural.domain.entity.activity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "activity_type")
public @Entity class ActivityType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "\"idActivityType\"")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "\"activity_type_idActivityType_seq\"")
	@SequenceGenerator(name = "\"activity_type_idActivityType_seq\"", sequenceName = "\"activity_type_idActivityType_seq\"", allocationSize = 1, initialValue = 1)
	private @Id Long id;

	@Column(name = "name", length = 120, nullable = false, unique = true)
	private String name;

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
