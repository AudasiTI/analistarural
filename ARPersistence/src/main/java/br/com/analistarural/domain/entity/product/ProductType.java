package br.com.analistarural.domain.entity.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "product_type")
public @Entity class ProductType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Column(name = "\"idProductType\"")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "\"product_type_idProductType_seq\"")
	@SequenceGenerator(name = "\"product_type_idProductType_seq\"", sequenceName = "\"product_type_idProductType_seq\"", allocationSize = 1)
	private @Id Long id;
	
	@Column(name = "description", length = 120, nullable = false, unique = true)
	private String description;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
	

}
