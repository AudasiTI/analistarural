package br.com.analistarural.domain.entity.activity;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Transient;

import br.com.analistarural.domain.entity.field.Field;

@Table(name = "activity")
public @Entity class Activity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "\"idActivity\"")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "\"system_account_idSystemAccount_seq\"")
	@SequenceGenerator(name = "\"system_account_idSystemAccount_seq\"", sequenceName = "\"system_account_idSystemAccount_seq\"", allocationSize = 1, initialValue = 1)
	private @Id Long id;

	@ManyToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "\"idActivityType\"", referencedColumnName = "\"idActivityType\"", nullable = false)
	private ActivityType activityType;

	@ManyToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "\"idField\"", referencedColumnName = "\"idField\"", nullable = false)
	private Field field;

	@Column(name = "abertura", length = 120, nullable = false)
	Date abertura = new Date();

	@Column(name = "fechamento", length = 120, nullable = true)
	Date fechamento = new Date();

	@Transient
	@Column(name = "cost", length = 120, nullable = true)
	private Long cost;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ActivityType getActivityType() {
		return activityType;
	}

	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}

}
