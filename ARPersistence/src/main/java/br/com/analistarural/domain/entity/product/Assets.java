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
@Table(name = "assets")
public class Assets implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "\"idAssets\"")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "\"assets_idAssets_seq\"")
    @SequenceGenerator(name = "\"assets_idAssets_seq\"", sequenceName = "\"assets_idAssets_seq\"", allocationSize = 1, initialValue = 1)
	@Id
	private Long idAssets;
	
	@Column(length = 120, nullable = false)
	private String patrimony;
	
	@Column(length = 120, nullable = false)
	private Double value;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "\"idProduct\"", nullable = false)
	private Product product;

	public Long getIdAssets() {
		return idAssets;
	}

	public void setIdAssets(Long idAssets) {
		this.idAssets = idAssets;
	}

	public String getPatrimony() {
		return patrimony;
	}

	public void setPatrimony(String patrimony) {
		this.patrimony = patrimony;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	
}
