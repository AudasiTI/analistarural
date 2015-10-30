package br.com.analistarural.domain.entity.product;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "default_gen")
	private Long id;
	
	@Column(length = 120, nullable = false)
	private String name;
	
	@Column(length = 60, nullable = false)
	private Double cost;
	
	@Column(length = 60, nullable = false)
	private String unity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
