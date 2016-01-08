package br.com.analistarural.domain.entity.product;


import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "fertilizer")
@SequenceGenerator(name = "default_gen", sequenceName = "\"fertilizer_idFertilizer_seq\"", allocationSize = 1)
@AttributeOverride(name = "id", column=@Column(name="\"idFertilizer\""))
public class Fertilizer extends Product{
	
	@Column(name = "\"percentualNitrogen\"")
	private String percentualNitrogen;
	
	@Column(name = "\"percentualPhosphate\"")
	private String percentualPhosphate;
	
	@Column(name = "\"percentualPotash\"")
	private String percentualPotash;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "\"idSource\"", nullable = false)
    private Source source;

	public String getPercentualNitrogen() {
		return percentualNitrogen;
	}

	public void setPercentualNitrogen(String percentualNitrogen) {
		this.percentualNitrogen = percentualNitrogen;
	}

	public String getPercentualPhosphate() {
		return percentualPhosphate;
	}

	public void setPercentualPhosphate(String percentualPhosphate) {
		this.percentualPhosphate = percentualPhosphate;
	}

	public String getPercentualPotash() {
		return percentualPotash;
	}

	public void setPercentualPotash(String percentualPotash) {
		this.percentualPotash = percentualPotash;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}
	 

}