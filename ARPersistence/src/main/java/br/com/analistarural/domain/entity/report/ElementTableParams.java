package br.com.analistarural.domain.entity.report;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "element_table_params")
public @Entity class ElementTableParams implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "element_table_params_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "element_table_element_table_params_id_seq")
	@SequenceGenerator(name = "element_table_element_table_params_id_seq", sequenceName = "element_table_element_table_params_id_seq", allocationSize = 1, initialValue = 1)
	private @Id Long id;

	@Column(name = "method", length = 60, nullable = false, unique = false)
	private String method;

	@Column(name = "registration", nullable = false, unique = false)
	private Date registration;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Date getRegistration() {
		return registration;
	}

	public void setRegistration(Date registration) {
		this.registration = registration;
	}
}
