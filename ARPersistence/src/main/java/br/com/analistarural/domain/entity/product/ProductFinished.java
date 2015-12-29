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
@Table(name = "product_finished")
public class ProductFinished implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "\"idProductFinished\"")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "\"product_finished_idProductFinished_seq\"")
    @SequenceGenerator(name = "\"product_finished_idProductFinished_seq\"", sequenceName = "\"product_finished_idProductFinished_seq\"", allocationSize = 1, initialValue = 1)
	@Id
	private Long ididProductFinished;
	
	@Column(name = "\"average_cost\"")
	private Double averageCost;
	
	@Column
	private Double quantity;
	
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "\"idProduct\"", nullable = false)
	private Product product;


	public Long getIdidProductFinished() {
		return ididProductFinished;
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


	public void setIdidProductFinished(Long ididProductFinished) {
		this.ididProductFinished = ididProductFinished;
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
