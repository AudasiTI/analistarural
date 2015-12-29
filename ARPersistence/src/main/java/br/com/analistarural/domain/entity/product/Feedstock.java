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
@Table(name = "feedstock")
public class Feedstock implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "\"idFeedstock\"")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "\"feedstock_idFeedstock_seq\"")
    @SequenceGenerator(name = "\"feedstock_idFeedstock_seq\"", sequenceName = "\"feedstock_idFeedstock_seq\"", allocationSize = 1, initialValue = 1)
	@Id
	private Long idFeedstock;
	
	@Column
	private String description;
	
	@Column
	private String brand;
	
	@Column
	private Double cost;
	
	@Column(name = "\"averageCost\"")
	private Double averageCost;
	
	@Column
	private Double quantity;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "\"idProduct\"", nullable = false)
	private Product product;

	public Long getIdFeedstock() {
		return idFeedstock;
	}

	public String getDescription() {
		return description;
	}

	public String getBrand() {
		return brand;
	}

	public Double getCost() {
		return cost;
	}

	public Double getAverageCost() {
		return averageCost;
	}

	public Double getQuantity() {
		return quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setIdFeedstock(Long idFeedstock) {
		this.idFeedstock = idFeedstock;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public void setAverageCost(Double averageCost) {
		this.averageCost = averageCost;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
}
