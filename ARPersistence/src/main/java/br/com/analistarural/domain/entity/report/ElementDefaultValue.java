package br.com.analistarural.domain.entity.report;

import java.io.Serializable;

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

@Table(name = "element_default_value")
public @Entity class ElementDefaultValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "element_default_value_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "element_default_value_id")
	@SequenceGenerator(name = "element_default_value_id", sequenceName = "soil_sample_result_soil_sample_result_id_seq", allocationSize = 1)
	private @Id Long id;

	@Column(name = "element_name")
	private String elementName;
	
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
	
	@Column(name = "child_element_name")
	private String childElementName;	
	
	@Column(name = "child_element_value")
	private String childElementValue;	
	
	@Column(name = "child_element_unit")
	private String childElementUnit;
	
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "element_table_params_id", referencedColumnName = "element_table_params_id", nullable = false)
	private ElementTableParams params;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
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

	public String getChildElementName() {
		return childElementName;
	}

	public void setChildElementName(String childElementName) {
		this.childElementName = childElementName;
	}

	public String getChildElementValue() {
		return childElementValue;
	}

	public void setChildElementValue(String childElementValue) {
		this.childElementValue = childElementValue;
	}

	public String getChildElementUnit() {
		return childElementUnit;
	}

	public void setChildElementUnit(String childElementUnit) {
		this.childElementUnit = childElementUnit;
	}

	public ElementTableParams getParams() {
		return params;
	}

	public void setParams(ElementTableParams params) {
		this.params = params;
	}
	
	

}
