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
@Table(name = "consumption")
public class Consumption implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "\"idConsumption\"")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "\"consumption_idconsumption_seq\"")
    @SequenceGenerator(name = "\"consumption_idconsumption_seq\"", sequenceName = "\"consumption_idconsumption_seq\"", allocationSize = 1, initialValue = 1)
	@Id
	private Long idConsumption;
	
	@Column(name = "\"unity_value\"")
	private Double unityValue;
	
	@Column
	private Double quantity;
		
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "\"idProduct\"", nullable = false)
	private Product product;

	public Long getId() {
		return idConsumption;
	}

	public Double getUnityValue() {
		return unityValue;
	}

	public Double getQuantity() {
		return quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setId(Long id) {
		this.idConsumption = id;
	}

	public void setUnityValue(Double unityValue) {
		this.unityValue = unityValue;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
