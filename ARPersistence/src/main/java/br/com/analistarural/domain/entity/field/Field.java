package br.com.analistarural.domain.entity.field;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "field")
public @Entity class Field implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "\"idField\"")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "\"field_idField_seq\"")
	@SequenceGenerator(name = "\"field_idField_seq\"", sequenceName = "\"field_idField_seq\"", allocationSize = 1)
	private @Id Long id;

	@Column(name = "name", length = 120, nullable = false)
	private String name;

	@ManyToOne(optional = true)
	@JoinColumn(name = "\"idFarm\"", referencedColumnName = "\"idFarm\"", nullable = false)
	private Farm farm;

	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "\"idFieldGroup\"", referencedColumnName = "\"idFieldGroup\"", nullable = true)
	private FieldGroup fieldGroup;

	@Column(name = "owner", nullable = false)
	private Boolean owner;

	@Column(name = "size", nullable = true)
	private Double size;

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

	public Farm getFarm() {
		return farm;
	}

	public void setFarm(Farm farm) {
		this.farm = farm;
	}

	public FieldGroup getFieldGroup() {
		return fieldGroup;
	}

	public void setFieldGroup(FieldGroup fieldGroup) {
		this.fieldGroup = fieldGroup;
	}

	public Boolean getOwner() {
		return owner;
	}

	public void setOwner(Boolean owner) {
		this.owner = owner;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

}
