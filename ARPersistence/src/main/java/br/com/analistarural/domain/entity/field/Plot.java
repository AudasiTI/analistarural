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

@Table(name = "plot")
public @Entity class Plot implements Serializable, Ground {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "\"idPlot\"")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "\"plot_idPlot_seq\"")
	@SequenceGenerator(name = "\"plot_idPlot_seq\"", sequenceName = "\"plot_idPlot_seq\"", allocationSize = 1)
	private @Id Long id;

	@Column(name = "name", length = 120, nullable = false)
	private String name;

	@OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "\"idFarm\"", nullable = false)
	private Farm farm;

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

}
