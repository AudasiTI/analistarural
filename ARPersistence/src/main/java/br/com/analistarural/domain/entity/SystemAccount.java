package br.com.analistarural.domain.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
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

	@OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "\"idAccountType\"", nullable = false)
	private AccountType accountType;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_account_system_account", joinColumns = { @JoinColumn(name = "\"idSystemAccount\"", referencedColumnName = "\"idSystemAccount\"") }, inverseJoinColumns = { @JoinColumn(name = "\"idUserAccount\"", referencedColumnName = "\"idUserAccount\"") })
	private List<UserAccount> userAccounts;

	public SystemAccount() {
	}

	public SystemAccount(SystemAccount systemAccount) {
		super();
		this.id = systemAccount.getId();
		this.setAccountType(systemAccount.getAccountType());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public List<UserAccount> getUserAccounts() {
		return userAccounts;
	}

	public void setUserAccounts(List<UserAccount> userAccounts) {
		this.userAccounts = userAccounts;
	}
}