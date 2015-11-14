package br.com.analistarural.domain.entity.activity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.analistarural.domain.entity.product.Fertilizer;

@Table(name = "activity_fertilizer")
public @Entity class ActivityFertilizer {

	@Column(name = "\"idActivityFertilizer\"")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "\"system_account_idSystemAccount_seq\"")
	@SequenceGenerator(name = "\"system_account_idSystemAccount_seq\"", sequenceName = "\"system_account_idSystemAccount_seq\"", allocationSize = 1, initialValue = 1)
	private @Id Long id;

	@ManyToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "\"idActivity\"", referencedColumnName = "\"idActivity\"", nullable = false)
	private Activity activity;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "\"idFertilizer\"", referencedColumnName = "\"idFertilizer\"", nullable = false)
	private Fertilizer fertilizer;

	@Column(name = "quantity", length = 120, nullable = true)
	private Long quantity;

	@Column(name = "cost", length = 10, nullable = true)
	private Double cost;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Fertilizer getFertilizer() {
		return fertilizer;
	}

	public void setFertilizer(Fertilizer fertilizer) {
		this.fertilizer = fertilizer;
	}

}
