package br.com.analistarural.domain.entity.product;

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

@Entity
@Table(name = "parts")
public class Parts implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "id_parts")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "parts_id_parts_seq")
	@SequenceGenerator(name = "parts_id_parts_seq", sequenceName = "parts_id_parts_seq", allocationSize = 1)
	private @Id Long idParts;
	
	@Column(name = "code2")
	private String code2;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_consumption", nullable = false)
	private Consumption consumption;

	public Long getIdParts() {
		return idParts;
	}

	public void setIdParts(Long idParts) {
		this.idParts = idParts;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public Consumption getConsumption() {
		return consumption;
	}

	public void setConsumption(Consumption consumption) {
		this.consumption = consumption;
	}
	
	
	
	
}
