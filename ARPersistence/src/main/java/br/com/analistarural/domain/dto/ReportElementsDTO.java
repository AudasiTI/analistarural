package br.com.analistarural.domain.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.analistarural.domain.entity.report.ElementValue;

public class ReportElementsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String customerElementIdent;

	private String elementName;

	private Double veryLowValue;

	private Double lowValue;

	private Double moderateValue;

	private Double goodValue;

	private Double highVlue;

	private String elementUnit;

	private String elementExtractor;

	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
	private Double measuredValue;

	public ReportElementsDTO() {
	}

	public ReportElementsDTO(ElementValue elements) {
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public ElementValue toElementValue(ReportElementsDTO reportElementsDTO) {

		ElementValue elementValue = new ElementValue();
		elementValue.setElementName(reportElementsDTO.getElementName());
		elementValue.setElementExtractor(reportElementsDTO.getElementExtractor());
		elementValue.setElementUnit(reportElementsDTO.getElementUnit());
		elementValue.setGoodValue(reportElementsDTO.getGoodValue());
		elementValue.setHighValue(reportElementsDTO.getHighVlue());
		elementValue.setCustomerElementIdent(reportElementsDTO.getCustomerElementIdent());
		elementValue.setElementUnit(reportElementsDTO.getElementUnit());
		elementValue.setGoodValue(reportElementsDTO.getGoodValue());
		elementValue.setHighValue(reportElementsDTO.getHighVlue());
		elementValue.setLowValue(reportElementsDTO.getLowValue());
		elementValue.setMeasuredValue(reportElementsDTO.getMeasuredValue());
		elementValue.setModerateValue(reportElementsDTO.getModerateValue());
		elementValue.setVeryLowValue(reportElementsDTO.getVeryLowValue());

		return elementValue;

	}

	public String getCustomerElementIdent() {
		return customerElementIdent;
	}

	public void setCustomerElementIdent(String elementID) {
		this.customerElementIdent = elementID;
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
		return highVlue;
	}

	public void setHighVlue(Double highVlue) {
		this.highVlue = highVlue;
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

	public Double getMeasuredValue() {
		return measuredValue;
	}

	public void setMeasuredValue(Double measuredValue) {
		this.measuredValue = measuredValue;
	}

}
