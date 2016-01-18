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

	// @ManyToOne(optional = true, fetch = FetchType.EAGER)
	// @JoinColumn(name = "element_type_id", referencedColumnName =
	// "element_type_id", nullable = false)
	// private ElementType elementType;

	@Column(name = "element_name")
	private String elementName;

	@Column(name = "measured_value")
	private String measuredValue;

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

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "soil_sample_result_id", referencedColumnName = "soil_sample_result_id", nullable = false)
	private SoilSampleResult sample;

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

	public String getMeasuredValue() {
		return measuredValue;
	}

	public void setMeasuredValue(String measuredValue) {
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

	public SoilSampleResult getSample() {
		return sample;
	}

	public void setSample(SoilSampleResult sample) {
		this.sample = sample;
	}
	
	public ElementValue(Long sampleID){
		sample = new SoilSampleResult();
		sample.setId(sampleID);
	}

	public ElementValue() {
		// TODO Auto-generated constructor stub
	}

}
