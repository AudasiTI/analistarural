package br.com.analistarural.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.analistarural.domain.entity.report.ElementValue;
import br.com.analistarural.domain.entity.report.Report;

public class ReportDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String email;

	private Boolean soilReport;

	private String secondaryEmail;

	private Date entryDate;

	private Date generationDate;

	private String customerCPF;

	private List<ReportElementsDTO> elements = new ArrayList<ReportElementsDTO>();

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ReportElementsDTO> getElements() {
		return elements;
	}

	public void setElements(List<ReportElementsDTO> elements) {
		this.elements = elements;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ReportDTO() {
	}

	public ReportDTO(Report report, Iterable<ElementValue> elements) {

		setEmail(report.getEmail());
		setId(report.getId());
		setCustomerCPF(report.getCustomerCpf());
		setEntryDate(report.getEntryDate());
		setGenerationDate(report.getGenerationDate());
		setSecondaryEmail(report.getSecondaryEmail());
		setSoilReport(report.getReportSoil());

		for (ElementValue elementValue : elements) {
			ReportElementsDTO elementDTO = new ReportElementsDTO(elementValue);
			getElements().add(elementDTO);

		}
	}

	public Report toReport(ReportDTO reportDTO) {

		Report report = new Report();
		report.setId(reportDTO.getId());
		report.setEmail(reportDTO.getEmail());
		report.setCustomerCpf(reportDTO.getCustomerCPF());
		report.setEntryDate(reportDTO.getEntryDate());
		report.setGenerationDate(reportDTO.getEntryDate());
		report.setReportSoil(reportDTO.getSoilReport());
		report.setSecondaryEmail(reportDTO.getSecondaryEmail());

		return report;

	}

	public Boolean getSoilReport() {
		return soilReport;
	}

	public void setSoilReport(Boolean soilReport) {
		this.soilReport = soilReport;
	}

	public String getSecondaryEmail() {
		return secondaryEmail;
	}

	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getGenerationDate() {
		return generationDate;
	}

	public void setGenerationDate(Date generationDate) {
		this.generationDate = generationDate;
	}

	public String getCustomerCPF() {
		return customerCPF;
	}

	public void setCustomerCPF(String customerCPF) {
		this.customerCPF = customerCPF;
	}

}
