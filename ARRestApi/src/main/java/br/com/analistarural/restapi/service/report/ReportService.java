package br.com.analistarural.restapi.service.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.dto.ReportDTO;
import br.com.analistarural.domain.dto.ReportElementsDTO;
import br.com.analistarural.domain.dto.SampleDTO;
import br.com.analistarural.domain.entity.report.Report;
import br.com.analistarural.domain.entity.report.SoilSampleResult;
import br.com.analistarural.domain.repository.report.ElementValueRepository;
import br.com.analistarural.domain.repository.report.ReportRepository;
import br.com.analistarural.domain.repository.report.SoilSampleResultRepository;

@Service
@Transactional
public class ReportService {

	@Autowired
	private ReportRepository reportRepository;

	@Autowired
	private SoilSampleResultRepository soilSampleResultRepository;

	@Autowired
	private ElementValueRepository elementValueRepository;

	public Iterable<Report> findAll() {
		return reportRepository.findAll();
	}

	public Iterable<ReportDTO> findReportsByEmail(String email) {

		List<ReportDTO> reportDTOList = new ArrayList<ReportDTO>();

		Iterable<Report> report = reportRepository.findByEmail(email);

		for (Report report2 : report) {
			reportDTOList.add(new ReportDTO(report2));
		}
		return reportDTOList;
	}

	@Transactional(readOnly = false)
	public void save(ReportDTO reportDTO) {

		Report report = reportRepository.save(reportDTO.toReport(reportDTO));

		for (SampleDTO iterator : reportDTO.getSamples()) {
			iterator.setReportID(report.getId());

			SoilSampleResult sample = soilSampleResultRepository.save(iterator.toSample(iterator));

			for (ReportElementsDTO elements : iterator.getElements()) {
				elements.setSampleID(sample.getId());
				elementValueRepository.save(elements.toElementValue(elements));
			}
		}
	}

	@Transactional(readOnly = false)
	public void updateReport(ReportDTO reportDTO) {

		Report report = reportRepository.save(reportDTO.toReport(reportDTO));

	}

	public void delete(Long id) {
		reportRepository.delete(id);
	}

}
