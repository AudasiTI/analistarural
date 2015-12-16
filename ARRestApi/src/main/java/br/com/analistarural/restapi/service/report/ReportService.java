package br.com.analistarural.restapi.service.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.dto.ReportDTO;
import br.com.analistarural.domain.dto.ReportElementsDTO;
import br.com.analistarural.domain.entity.report.ElementType;
import br.com.analistarural.domain.entity.report.ElementValue;
import br.com.analistarural.domain.entity.report.Report;
import br.com.analistarural.domain.repository.report.ElementTypeRepository;
import br.com.analistarural.domain.repository.report.ElementValueRepository;
import br.com.analistarural.domain.repository.report.ReportRepository;

@Service
@Transactional
public class ReportService {

	@Autowired
	private ReportRepository reportRepository;

	@Autowired
	private ElementValueRepository elementValueRepository;

	@Autowired
	private ElementTypeRepository elementTypeRepository;

	public Iterable<Report> findAll() {
		return reportRepository.findAll();
	}

	public Iterable<ReportDTO> findReportsByEmail(String email) {

		List<ReportDTO> reportDTOList = new ArrayList<ReportDTO>();

		Iterable<Report> report = reportRepository.findByEmail(email);

		for (Report report2 : report) {
			reportDTOList.add(new ReportDTO(report2, elementValueRepository.findByReport(report2.getId())));
		}
		return reportDTOList;
	}

	@Transactional(readOnly = false)
	public void save(ReportDTO reportDTO) {

		Report report = reportRepository.save(reportDTO.toReport(reportDTO));

		for (ReportElementsDTO elementDTO : reportDTO.getElements()) {

			ElementValue elementValue = elementDTO.toElementValue(elementDTO);
			ElementType elementType = elementTypeRepository.findByDescription(elementValue.getElementName()).get();
			elementValue.setReport(report);
			elementValue.setElementType(elementType);
			elementValue.setDefaultValue(elementType.getDefaultValue());
			elementValueRepository.save(elementValue);
		}

	}

	public void delete(Long id) {
		reportRepository.delete(id);
	}

}
