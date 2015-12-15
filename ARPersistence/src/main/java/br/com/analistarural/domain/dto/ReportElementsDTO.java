package br.com.analistarural.domain.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.analistarural.domain.entity.report.ElementValue;

public class ReportElementsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String elementName;

	private Long elementDefaultValue;

	@JsonFormat(shape=JsonFormat.Shape.NUMBER_FLOAT)
	private Long elementValue;

	public ReportElementsDTO() {
	}

	public ReportElementsDTO(ElementValue elements) {
		setElementName(elements.getElementType().getDescription());
		setElementValue(elements.getValue());
		setElementDefaultValue(elements.getDefaultValue());
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public Long getElementDefaultValue() {
		return elementDefaultValue;
	}

	public void setElementDefaultValue(Long elementDefaultValue) {
		this.elementDefaultValue = elementDefaultValue;
	}

	public Long getElementValue() {
		return elementValue;
	}

	public void setElementValue(Long elementValue) {
		this.elementValue = elementValue;
	}

	public ElementValue toElementValue(ReportElementsDTO reportElementsDTO) {

		ElementValue elementValue = new ElementValue();
		elementValue.setValue(reportElementsDTO.getElementValue());
		elementValue.setElementName(reportElementsDTO.getElementName());
		elementValue.setDefaultValue(reportElementsDTO.getElementDefaultValue());
		return elementValue;

	}

}
