package br.com.analistarural.domain.entity.Account;

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

@Table(name = "user_account")
public @Entity class UserAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "\"idUserAccount\"")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "\"user_account_idUserAccount_seq\"")
	@SequenceGenerator(name = "\"user_account_idUserAccount_seq\"", sequenceName = "\"user_account_idUserAccount_seq\"", allocationSize = 1)
	private @Id Long id;

	@Column(name = "email", length = 120, nullable = false, unique = true)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "\"idSystemAccount\"", nullable = false)
	private SystemAccount systemAccount;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "\"idTypeUserAccount\"", nullable = false)
	private TypeUserAccount typeUserAccount;

	public UserAccount() {
	}

	public UserAccount(UserAccount user) {
		super();
		this.id = user.getId();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.systemAccount = user.systemAccount;
		this.typeUserAccount = user.typeUserAccount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SystemAccount getSystemAccount() {
		return systemAccount;
	}

	public void setSystemAccount(SystemAccount systemAccount) {
		this.systemAccount = systemAccount;
	}

	public TypeUserAccount getTypeUserAccount() {
		return typeUserAccount;
	}

	public void setTypeUserAccount(TypeUserAccount typeUserAccount) {
		this.typeUserAccount = typeUserAccount;
	}

}
