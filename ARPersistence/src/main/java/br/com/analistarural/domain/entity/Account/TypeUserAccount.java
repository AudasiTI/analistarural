package br.com.analistarural.domain.entity.Account;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "type_user_account")
public @Entity class TypeUserAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "\"idTypeUserAccount\"")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "\"account_type_idAccountType_seq\"")
	@SequenceGenerator(name = "\"account_type_idAccountType_seq\"", sequenceName = "\"account_type_idAccountType_seq\"", allocationSize = 1)
	private @Id Long id;

	@Column(name = "name", length = 120, nullable = false, unique = true)
	private String name;

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

	public TypeUserAccount() {
	}

	public TypeUserAccount(String type) {
		super();
		this.name = type;
	}

}
