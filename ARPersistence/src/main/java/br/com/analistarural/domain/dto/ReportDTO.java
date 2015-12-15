package br.com.analistarural.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.analistarural.domain.entity.report.ElementValue;
import br.com.analistarural.domain.entity.report.Report;

public class ReportDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String email;

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

		for (ElementValue elementValue : elements) {
			ReportElementsDTO elementDTO = new ReportElementsDTO(elementValue);
			getElements().add(elementDTO);

		}
	}

	public Report toReport(ReportDTO reportDTO) {

		Report report = new Report();
		report.setId(reportDTO.getId());
		report.setEmail(reportDTO.getEmail());

		return report;

	}

}
