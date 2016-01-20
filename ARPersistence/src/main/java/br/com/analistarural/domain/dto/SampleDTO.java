package br.com.analistarural.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.analistarural.domain.entity.report.ElementValue;
import br.com.analistarural.domain.entity.report.Report;
import br.com.analistarural.domain.entity.report.SoilSampleResult;

public class SampleDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String customerElementIdent;

	private String crop;

	private String field;

	private String tipoAnalise;

	private List<ReportElementsDTO> elements = new ArrayList<ReportElementsDTO>();

	public String getCustomerElementIdent() {
		return customerElementIdent;
	}

	public void setCustomerElementIdent(String customerElementIdent) {
		this.customerElementIdent = customerElementIdent;
	}

	public String getCrop() {
		return crop;
	}

	public void setCrop(String crop) {
		this.crop = crop;
	}

	public String getField() {
		return field;
	}

	public void setField(String fieldParam) {
		field = fieldParam;
	}

	public String getTipoAnalise() {
		return tipoAnalise;
	}

	public void setTipoAnalise(String tipoAnalise) {
		this.tipoAnalise = tipoAnalise;
	}

	public List<ReportElementsDTO> getElements() {
		return elements;
	}

	public void setElements(List<ReportElementsDTO> elements) {
		this.elements = elements;
	}

	public SampleDTO(SoilSampleResult sample) {

		setCrop(sample.getCrop());
		setCustomerElementIdent(sample.getIdent());
		setField(sample.getField());
		setTipoAnalise(sample.getTipoAnalise());

		for (ElementValue iterator : sample.getElementValues()) {

			if ((iterator.getMeasuredValue() != null) && (!iterator.getMeasuredValue().contentEquals("ns"))) {
				getElements().add(new ReportElementsDTO(iterator));
			}
		}

	}

	public SoilSampleResult toSample(SampleDTO sampleDTO, Long reportID) {

		SoilSampleResult sample = new SoilSampleResult(reportID);
		sample.setCrop(sampleDTO.getCrop());
		sample.setField(sampleDTO.getField());
		sample.setIdent(sampleDTO.getCustomerElementIdent());
		sample.setTipoAnalise(sampleDTO.getTipoAnalise());

		return sample;

	}

	public SampleDTO() {

	}

}
