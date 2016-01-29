package br.com.analistarural.domain.entity.product;

import java.io.Serializable;

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

@Entity
@Table(name = "defensive")
public class Defensive implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "id_defensive")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "defensive_id_defensive_seq")
    @SequenceGenerator(name = "defensive_id_defensive_seq", sequenceName = "defensive_id_defensive_seq", allocationSize = 1, initialValue = 1)
	@Id
	private Long idDefensive;

	@Column(name = "restrict_use")
	private Boolean restrictUse;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_defensive_type", nullable = false)
    private DefensiveType defensiveType;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_feedstock", nullable = false)
	private Feedstock feedstock;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_chemical_element", nullable = false)
	private ChemicalElement chemicalElement;
	

	public Long getIdDefensive() {
		return idDefensive;
	}

	public void setIdDefensive(Long idDefensive) {
		this.idDefensive = idDefensive;
	}

	public Boolean getRestrictUse() {
		return restrictUse;
	}

	public void setRestrictUse(Boolean restrictUse) {
		this.restrictUse = restrictUse;
	}

	public DefensiveType getDefensiveType() {
		return defensiveType;
	}

	public void setDefensiveType(DefensiveType defensiveType) {
		this.defensiveType = defensiveType;
	}

	public Feedstock getFeedstock() {
		return feedstock;
	}

	public void setFeedstock(Feedstock feedstock) {
		this.feedstock = feedstock;
	}

	public ChemicalElement getChemicalElement() {
		return chemicalElement;
	}

	public void setChemicalElement(ChemicalElement chemicalElement) {
		this.chemicalElement = chemicalElement;
	}

	
	
}
