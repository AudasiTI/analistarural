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

	private String Field;

	private String tipoAnalise;

	private Long reportID;

	private Long id;

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
		return Field;
	}

	public void setField(String field) {
		Field = field;
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
		setReportID(sample.getReport().getId());

		for (ElementValue iterator : sample.getElementValues()) {
			getElements().add(new ReportElementsDTO(iterator));
		}

	}

	public SoilSampleResult toSample(SampleDTO sampleDTO) {

		SoilSampleResult sample = new SoilSampleResult(sampleDTO.getReportID());
		sample.setCrop(sampleDTO.getCrop());
		sample.setField(sampleDTO.getField());
		sample.setIdent(sampleDTO.getCustomerElementIdent());
		sample.setTipoAnalise(sampleDTO.getTipoAnalise());

		return sample;

	}

	public Long getReportID() {
		return reportID;
	}

	public void setReportID(Long reportID) {
		this.reportID = reportID;
	}

	public SampleDTO() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
