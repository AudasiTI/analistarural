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

	@Column(name = "lab", nullable = false, unique = false)
	private Long lab;

	@Column(name = "id", length = 30, nullable = false, unique = false)
	private String customerElementIdent;

	// @ManyToOne(optional = true, fetch = FetchType.EAGER)
	// @JoinColumn(name = "element_type_id", referencedColumnName =
	// "element_type_id", nullable = false)
	// private ElementType elementType;

	@Column(name = "element_name")
	private String elementName;

	@Column(name = "measured_value")
	private Double measuredValue;

	@Column(name = "very_low_value")
	private Double veryLowValue;

	@Column(name = "low_value")
	private Double lowValue;

	@Column(name = "moderate_value")
	private Double moderateValue;

	@Column(name = "good_value")
	private Double goodValue;

	@Column(name = "high_value")
	private Double highValue;

	@Column(name = "element_unit")
	private String elementUnit;

	@Column(name = "element_extractor")
	private String elementExtractor;

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

	public String getCustomerElementIdent() {
		return customerElementIdent;
	}

	public void setCustomerElementIdent(String ident) {
		this.customerElementIdent = ident;
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

	public Double getMeasuredValue() {
		return measuredValue;
	}

	public void setMeasuredValue(Double measuredValue) {
		this.measuredValue = measuredValue;
	}

	public Double getVeryLowValue() {
		return veryLowValue;
	}

	public void setVeryLowValue(Double veryLowValue) {
		this.veryLowValue = veryLowValue;
	}

	public Double getLowValue() {
		return lowValue;
	}

	public void setLowValue(Double lowValue) {
		this.lowValue = lowValue;
	}

	public Double getModerateValue() {
		return moderateValue;
	}

	public void setModerateValue(Double moderateValue) {
		this.moderateValue = moderateValue;
	}

	public Double getGoodValue() {
		return goodValue;
	}

	public void setGoodValue(Double goodValue) {
		this.goodValue = goodValue;
	}

	public Double getHighValue() {
		return highValue;
	}

	public void setHighValue(Double highValue) {
		this.highValue = highValue;
	}

	public String getElementUnit() {
		return elementUnit;
	}

	public void setElementUnit(String elementUnit) {
		this.elementUnit = elementUnit;
	}

	public String getElementExtractor() {
		return elementExtractor;
	}

	public void setElementExtractor(String elementExtractor) {
		this.elementExtractor = elementExtractor;
	}

}
