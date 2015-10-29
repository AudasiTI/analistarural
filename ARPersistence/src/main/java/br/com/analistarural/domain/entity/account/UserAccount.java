package br.com.analistarural.domain.entity.account;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.analistarural.domain.entity.auth.Role;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
    private Set<Role> roles = new HashSet<Role>();

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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
