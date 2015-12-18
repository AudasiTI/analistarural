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

	@Column(name = "\"idDefensive\"")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "\"defensive_idDefensive_seq\"")
    @SequenceGenerator(name = "\"defensive_idDefensive_seq\"", sequenceName = "\"defensive_idDefensive_seq\"", allocationSize = 1, initialValue = 1)
	@Id
	private Long idDefensive;

	@Column(name = "\"restrictUse\"")
	private Boolean restrictUse;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "\"idDefensiveType\"", nullable = false)
    private DefensiveType defensiveType;
	

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

	
	
}
