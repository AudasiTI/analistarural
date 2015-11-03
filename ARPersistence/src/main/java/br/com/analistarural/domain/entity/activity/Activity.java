package br.com.analistarural.domain.entity.activity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.analistarural.domain.entity.field.Field;

@Table(name = "activity")
public abstract class Activity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "\"idActivity\"")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "\"system_account_idSystemAccount_seq\"")
	@SequenceGenerator(name = "\"system_account_idSystemAccount_seq\"", sequenceName = "\"system_account_idSystemAccount_seq\"", allocationSize = 1, initialValue = 1)
	private @Id Long id;

	@ManyToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "\"idField\"", referencedColumnName = "\"idField\"", nullable = false)
	private Field field;
	

}
