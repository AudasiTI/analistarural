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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "product")
public class Product implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Column(name = "id_product")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "product_id_product_seq")
    @SequenceGenerator(name = "product_id_product_seq", sequenceName = "product_id_product_seq", allocationSize = 1, initialValue = 1)
	@Id
	private Long idProduct;


	@Column(length = 120, nullable = false)
	@NotNull(message = "{error.name.notnull}")
    @NotEmpty(message = "{error.name.notEmpty}")
	private String name;

	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_measurement", nullable = false)
	private Measurement measurement;


	public Long getIdProduct() {
		return idProduct;
	}


	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Measurement getMeasurement() {
		return measurement;
	}


	public void setMeasurement(Measurement measurement) {
		this.measurement = measurement;
	}
	
	
	
	}
