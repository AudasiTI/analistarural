package br.com.analistarural.domain.entity.product;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@MappedSuperclass
public abstract class Product {
	
	
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "default_gen")
	protected @Id Long id;
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(length = 120, nullable = false)
	@NotNull(message = "{error.name.notnull}")
    @NotEmpty(message = "{error.name.notEmpty}")
	private String name;
	
	@Column(length = 60, nullable = false)
	private Double cost;
	
	@Column(length = 60, nullable = false)
	private String unity;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "\"idProductType\"", nullable = false)
	private ProductType productType;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "\"idProductCategory\"", nullable = false)
	private ProductCategory productCategory;

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getUnity() {
		return unity;
	}

	public void setUnity(String unity) {
		this.unity = unity;
	}
	
	

}
