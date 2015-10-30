package br.com.analistarural.domain.entity.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "product_category")

public @Entity class ProductCategory implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "\"idProductCategory\"")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "\"product_category_idProductCategory_seq\"")
	@SequenceGenerator(name = "\"product_category_idProductCategory_seq\"", sequenceName = "\"product_category_idProductCategory_seq\"", allocationSize = 1)
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
