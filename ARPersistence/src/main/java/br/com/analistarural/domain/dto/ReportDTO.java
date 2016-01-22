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

	private String primaryEmail;

	private String secondaryEmail;

	private Boolean soilReport;

	private Date entryDate;

	private Date generationDate;

	private String customerCPF;

	private String city;

	private String farm;

	private List<SampleDTO> samples = new ArrayList<SampleDTO>();

	public ReportDTO() {
	}

	public ReportDTO(Report report, Boolean deepLoad) {

		setPrimaryEmail(report.getPrimaryEmail());
		setId(report.getId());
		setCustomerCPF(report.getCustomerCpf());
		setEntryDate(report.getEntryDate());
		setGenerationDate(report.getGenerationDate());
		setSecondaryEmail(report.getSecondaryEmail());
		setSoilReport(report.getReportSoil());
		setFarm(report.getFarm());
		setCode(report.getCode());

		if (deepLoad) {
			for (SoilSampleResult iterator : report.getSoilSampleResults()) {
				getSamples().add(new SampleDTO(iterator));

			}
		}
	}

	public Report toReport(ReportDTO reportDTO) {

		Report report = new Report();
		report.setId(reportDTO.getId());
		report.setPrimaryEmail(reportDTO.getPrimaryEmail());
		report.setCustomerCpf(reportDTO.getCustomerCPF());
		report.setEntryDate(reportDTO.getEntryDate());
		report.setGenerationDate(reportDTO.getEntryDate());
		report.setReportSoil(reportDTO.getSoilReport());
		report.setSecondaryEmail(reportDTO.getSecondaryEmail());
		report.setCode(reportDTO.getCode());
		report.setFarm(reportDTO.getFarm());

		return report;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	public String getSecondaryEmail() {
		return secondaryEmail;
	}

	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}

	public Boolean getSoilReport() {
		return soilReport;
	}

	public void setSoilReport(Boolean soilReport) {
		this.soilReport = soilReport;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFarm() {
		return farm;
	}

	public void setFarm(String farm) {
		this.farm = farm;
	}

	public List<SampleDTO> getSamples() {
		return samples;
	}

	public void setSamples(List<SampleDTO> samples) {
		this.samples = samples;
	}
}
