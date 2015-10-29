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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "field")
public @Entity class Field implements Serializable, Ground {

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

	@OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "\"idPlot\"", nullable = false)
	private Plot plot;

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

	public Plot getPlot() {
		return plot;
	}

	public void setPlot(Plot plot) {
		this.plot = plot;
	}

}
