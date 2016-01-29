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


@Table(name = "tools")
@Entity
public class Tools implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_tools")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tools_id_tools_seq")
	@SequenceGenerator(name = "tools_id_tools_seq", sequenceName = "tools_id_tools_seq", allocationSize = 1)
	private @Id Long idTools;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_consumption", nullable = false)
	private Consumption consumption;

	public Long getIdTools() {
		return idTools;
	}

	public void setIdTools(Long idTools) {
		this.idTools = idTools;
	}

	public Consumption getConsumption() {
		return consumption;
	}

	public void setConsumption(Consumption consumption) {
		this.consumption = consumption;
	}
	
	
}
