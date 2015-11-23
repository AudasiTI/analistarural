package br.com.analistarural.domain.entity.field;

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

import br.com.analistarural.domain.entity.account.SystemAccount;

@Table(name = "farm")
public @Entity class Farm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "\"idFarm\"")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "\"farm_idFarm_seq\"")
	@SequenceGenerator(name = "\"farm_idFarm_seq\"", sequenceName = "\"farm_idFarm_seq\"", allocationSize = 1)
	private @Id Long id;

	@Column(name = "name", length = 120, nullable = false)
	@NotNull(message = "{error.name.notnull}")
    @NotEmpty(message = "{error.name.notEmpty}")
	private String name;

	@OneToOne(optional = true, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "\"idSystemAccount\"", nullable = false)
	private SystemAccount systemAccount;

	public Farm() {
	}

	public Farm(Farm farm) {
		super();
		this.id = farm.getId();
		this.name = farm.getName();
		this.systemAccount = farm.getSystemAccount();
	}

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

	public SystemAccount getSystemAccount() {
		return systemAccount;
	}

	public void setSystemAccount(SystemAccount systemAccount) {
		this.systemAccount = systemAccount;
	}

}
