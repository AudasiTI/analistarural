package br.com.analistarural.domain.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.analistarural.domain.entity.report.ElementDefaultValue;
import br.com.analistarural.domain.entity.report.ElementValue;

public class ReportElementsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String elementName;

	private String elementUnit;

	private String elementExtractor;

	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
	private String measuredValue;

	private Double veryLowValue;

	private Double lowValue;

	private Double moderateValue;

	private Double goodValue;

	private Double highValue;

	public ReportElementsDTO() {
	}

	public ReportElementsDTO(ElementValue elements) {

		setElementExtractor(elements.getElementExtractor());
		setElementName(elements.getElementName());
		setElementUnit(elements.getElementUnit());
		setMeasuredValue(elements.getMeasuredValue());
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public ElementValue toElementValue(ReportElementsDTO reportElementsDTO, Long sampleID) {

		ElementValue elementValue = new ElementValue(sampleID);

		elementValue.setElementName(reportElementsDTO.getElementName());
		elementValue.setElementExtractor(reportElementsDTO.getElementExtractor());
		elementValue.setElementUnit(reportElementsDTO.getElementUnit());
		elementValue.setElementUnit(reportElementsDTO.getElementUnit());
		elementValue.setMeasuredValue(reportElementsDTO.getMeasuredValue());

		return elementValue;

	}

	public void setDefaults(ElementDefaultValue elementDefaults) {

		setVeryLowValue(elementDefaults.getVeryLowValue());
		setLowValue(elementDefaults.getLowValue());
		setModerateValue(elementDefaults.getModerateValue());
		setGoodValue(elementDefaults.getGoodValue());
		setHighVlue(elementDefaults.getHighValue());
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

	public Double getHighVlue() {
		return highValue;
	}

	public void setHighVlue(Double highVlue) {
		this.highValue = highVlue;
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

	public String getMeasuredValue() {
		return measuredValue;
	}

	public void setMeasuredValue(String measuredValue) {
		this.measuredValue = measuredValue;
	}

}
