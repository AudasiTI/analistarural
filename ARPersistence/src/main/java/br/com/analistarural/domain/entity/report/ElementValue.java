package br.com.analistarural.domain.entity.report;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "element_value")
public @Entity class ElementValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "element_value_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "element_value_element_value_id_seq")
	@SequenceGenerator(name = "element_value_element_value_id_seq", sequenceName = "element_value_element_value_id_seq", allocationSize = 1)
	private @Id Long id;

	@Column(name = "lab", nullable = false, unique = true)
	private Long lab;

	@Column(name = "id", length = 30, nullable = false, unique = true)
	private String ident;

	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "element_type_id", referencedColumnName = "element_type_id", nullable = false)
	private ElementType elementType;

	@Column(name = "element_name")
	private String elementName;
	
	
	@Column(name = "default_value")
	private Double defaultValue;
	
	@Column(name = "value")
	private Double value;

	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "report_id", referencedColumnName = "report_id", nullable = false)
	private Report report;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLab() {
		return lab;
	}

	public void setLab(Long lab) {
		this.lab = lab;
	}

	public String getIdent() {
		return ident;
	}

	public void setIdent(String ident) {
		this.ident = ident;
	}

	public ElementType getElementType() {
		return elementType;
	}

	public void setElementType(ElementType elementType) {
		this.elementType = elementType;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public Double getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(Double defaultValue) {
		this.defaultValue = defaultValue;
	}

}
