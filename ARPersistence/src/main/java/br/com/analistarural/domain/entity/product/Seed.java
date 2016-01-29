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
@Table(name = "seed")
public class Seed implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_seed")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seed_id_seed_seq")
	@SequenceGenerator(name = "seed_id_seed_seq", sequenceName = "seed_id_seed_seq", allocationSize = 1)
	private @Id Long idSeed;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_variety", nullable = false)
	private Variety variety;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_feedstock", nullable = false)
	private Feedstock feedstock;

	public Variety getVariety() {
		return variety;
	}

	public void setVariety(Variety variety) {
		this.variety = variety;
	}

	public Long getIdSeed() {
		return idSeed;
	}

	public void setIdSeed(Long idSeed) {
		this.idSeed = idSeed;
	}

	public Feedstock getFeedstock() {
		return feedstock;
	}

	public void setFeedstock(Feedstock feedstock) {
		this.feedstock = feedstock;
	}
	
	
}
