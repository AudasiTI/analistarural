package br.com.analistarural.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import br.com.analistarural.domain.entity.report.ElementValue;
import br.com.analistarural.domain.entity.report.Report;
import br.com.analistarural.domain.entity.report.SoilSampleResult;

public class ReportDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String code;

	private String email;

	private Boolean soilReport;

	private String secondaryEmail;

	private Date entryDate;

	private Date generationDate;

	private String customerCPF;

	private String city;

	private String farm;

	private List<SampleDTO> samples = new ArrayList<SampleDTO>();

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ReportDTO() {
	}

	public ReportDTO(Report report) {

		setEmail(report.getEmail());
		setId(report.getId());
		setCustomerCPF(report.getCustomerCpf());
		setEntryDate(report.getEntryDate());
		setGenerationDate(report.getGenerationDate());
		setSecondaryEmail(report.getSecondaryEmail());
		setSoilReport(report.getReportSoil());

		for (SoilSampleResult iterator : report.getSoilSampleResults()) {
			getSamples().add(new SampleDTO(iterator));

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFarm() {
		return farm;
	}

	public void setFarm(String farm) {
		this.farm = farm;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<SampleDTO> getSamples() {
		return samples;
	}

	public void setSamples(List<SampleDTO> samples) {
		this.samples = samples;
	}

}
