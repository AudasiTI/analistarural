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

@Entity
@Table(name = "seed")
@SequenceGenerator(name = "default_gen", sequenceName = "\"seed_idSeed_seq\"", allocationSize = 1)
@AttributeOverride(name = "id", column=@Column(name="\"idSeed\""))
public class Seed extends Product {

	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "\"idVariety\"", nullable = false)
	private Variety variety;

	public Variety getVariety() {
		return variety;
	}

	public void setVariety(Variety variety) {
		this.variety = variety;
	}
	
	
}
