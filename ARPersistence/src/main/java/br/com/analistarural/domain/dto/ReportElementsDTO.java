package br.com.analistarural.domain.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.analistarural.domain.entity.report.ElementValue;
import br.com.analistarural.domain.entity.report.SoilSampleResult;

public class ReportElementsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String elementName;

	private Double veryLowValue;

	private Double lowValue;

	private Double moderateValue;

	private Double goodValue;

	private Double highVlue;

	private String elementUnit;

	private String elementExtractor;

	private Long SampleID;

	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
	private String measuredValue;

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

		ElementValue elementValue = new ElementValue(reportElementsDTO.getSampleID());

		elementValue.setElementName(reportElementsDTO.getElementName());
		elementValue.setElementExtractor(reportElementsDTO.getElementExtractor());
		elementValue.setElementUnit(reportElementsDTO.getElementUnit());
		elementValue.setGoodValue(reportElementsDTO.getGoodValue());
		elementValue.setHighValue(reportElementsDTO.getHighVlue());
		elementValue.setElementUnit(reportElementsDTO.getElementUnit());
		elementValue.setGoodValue(reportElementsDTO.getGoodValue());
		elementValue.setHighValue(reportElementsDTO.getHighVlue());
		elementValue.setLowValue(reportElementsDTO.getLowValue());
		elementValue.setMeasuredValue(reportElementsDTO.getMeasuredValue());
		elementValue.setModerateValue(reportElementsDTO.getModerateValue());
		elementValue.setVeryLowValue(reportElementsDTO.getVeryLowValue());

		return elementValue;

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

	public String getMeasuredValue() {
		return measuredValue;
	}

	public void setMeasuredValue(String measuredValue) {
		this.measuredValue = measuredValue;
	}

	public Long getSampleID() {
		return SampleID;
	}

	public void setSampleID(Long sampleID) {
		SampleID = sampleID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
