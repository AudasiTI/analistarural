package br.com.analistarural.domain.entity.account;

import java.io.Serializable;

import javax.persistence.CascadeType;
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

@Table(name = "system_account")
public @Entity class SystemAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "\"idSystemAccount\"")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "\"system_account_idSystemAccount_seq\"")
	@SequenceGenerator(name = "\"system_account_idSystemAccount_seq\"", sequenceName = "\"system_account_idSystemAccount_seq\"", allocationSize = 1, initialValue = 1)
	private @Id Long id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "\"idSystemAccountState\"", nullable = false)
	private SystemAccountState state;

	public SystemAccount() {
	}

	public SystemAccount(SystemAccount systemAccount) {
		super();
		this.id = systemAccount.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SystemAccountState getState() {
		return state;
	}

	public void setState(SystemAccountState state) {
		this.state = state;
	}

}