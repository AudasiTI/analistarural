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
@Table(name = "produced_seed")
public class ProducedSeed implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Column(name = "id_produced_seed")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "produced_seed_id_produced_seed_seq")
    @SequenceGenerator(name = "produced_seed_id_produced_seed_seq", sequenceName = "produced_seed_id_produced_seed_seq", allocationSize = 1, initialValue = 1)
	@Id
	private Long idProducedSeed;
	
	
	@Column(name="description_type")
	private String descriptionType;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_product_finished", nullable = false)
	private ProductFinished productFinished;

	public Long getIdProducedSeed() {
		return idProducedSeed;
	}

	public void setIdProducedSeed(Long idProducedSeed) {
		this.idProducedSeed = idProducedSeed;
	}

	public String getDescriptionType() {
		return descriptionType;
	}

	public void setDescriptionType(String descriptionType) {
		this.descriptionType = descriptionType;
	}

	public ProductFinished getProductFinished() {
		return productFinished;
	}

	public void setProductFinished(ProductFinished productFinished) {
		this.productFinished = productFinished;
	}
	
	
	
	
	

}
