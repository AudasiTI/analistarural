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

@Entity
@Table(name="chemical_element")
public class ChemicalElement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "id_chemical_element")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "chemical_element_id_chemical_element_seq")
    @SequenceGenerator(name = "chemical_element_id_chemical_element_seq", sequenceName = "chemical_element_id_chemical_element_seq", allocationSize = 1, initialValue = 1)
	@Id
	private Long idChemicalElement;
	
	@Column(length = 120, nullable = false)
	@NotNull(message = "{error.name.notnull}")
    @NotEmpty(message = "{error.name.notEmpty}")
	private String name;
	
	@Column
	private Double percentage;

	public Long getIdChemicalElement() {
		return idChemicalElement;
	}

	public void setIdChemicalElement(Long idChemicalElement) {
		this.idChemicalElement = idChemicalElement;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	
}
