package br.com.analistarural.domain.entity.product;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "chemical")
@SequenceGenerator(name = "default_gen", sequenceName = "\"chemical_idChemical_seq\"", allocationSize = 1)
@AttributeOverride(name = "id", column=@Column(name="\"idChemical\""))
public class Chemical extends Product{
	
	@Column(name = "\"restrictUse\"")
	private Boolean restrictUse;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "\"idChemicalType\"", nullable = false)
    private ChemicalType chemicalType;

	public Boolean getRestrictUse() {
		return restrictUse;
	}

	public void setRestrictUse(Boolean restrictUse) {
		this.restrictUse = restrictUse;
	}

	public ChemicalType getChemicalType() {
		return chemicalType;
	}

	public void setChemicalType(ChemicalType chemicalType) {
		this.chemicalType = chemicalType;
	}

	
	
}
