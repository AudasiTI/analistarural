package br.com.analistarural.domain.entity.account;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "system_account_state")
public @Entity class SystemAccountState implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "\"idSystemAccountState\"")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "\"system_account_state_idSystemAccountState_seq\"")
	@SequenceGenerator(name = "\"system_account_state_idSystemAccountState_seq\"", sequenceName = "\"system_account_state_idSystemAccountState_seq\"", allocationSize = 1)
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

}
