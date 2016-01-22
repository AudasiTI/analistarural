package br.com.analistarural.restapi.service.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.dto.ReportDTO;
import br.com.analistarural.domain.dto.ReportElementsDTO;
import br.com.analistarural.domain.dto.SampleDTO;
import br.com.analistarural.domain.entity.report.ElementDefaultValue;
import br.com.analistarural.domain.entity.report.Report;
import br.com.analistarural.domain.entity.report.SoilSampleResult;
import br.com.analistarural.domain.repository.report.ElementDefaultValueRepository;
import br.com.analistarural.domain.repository.report.ElementTableParamsRepository;
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

	@Autowired
	private ElementTableParamsRepository elementTableParamsRepository;

	@Autowired
	private ElementDefaultValueRepository elementDefaultValueRepository;

	public Iterable<Report> findAll() {
		return reportRepository.findAll();
	}

	public Iterable<ReportDTO> findReportsByEmail(String emailParam) {

		List<ReportDTO> reportDTOList = new ArrayList<ReportDTO>();

		Iterable<Report> reportList = reportRepository.findByPrimaryEmail(emailParam);

		for (Report report : reportList) {

			ReportDTO reportDTO = new ReportDTO(report, true);

			for (SampleDTO sample : reportDTO.getSamples()) {

				for (ReportElementsDTO element : sample.getElements()) {

					try {
						ElementDefaultValue elementDefaults = elementDefaultValueRepository
								.findByName(element.getElementName(), report.getParams().getId()).get();
						element.setDefaults(elementDefaults);
					} catch (Exception e) {
						// TODO: handle exception
					}

				}
			}

			reportDTOList.add(reportDTO);
		}
		return reportDTOList;
	}

	@Transactional(readOnly = false)
	public void save(ReportDTO reportDTO) {

		Report report = reportDTO.toReport(reportDTO);

		if (reportDTO.getGenerationDate() == null) {
			reportDTO.setGenerationDate(new Date(System.currentTimeMillis()));
		}

		report.setParams(elementTableParamsRepository.findFirstByRegistration(reportDTO.getGenerationDate()).get());

		report = reportRepository.save(report);

		for (SampleDTO iterator : reportDTO.getSamples()) {

			SoilSampleResult sample = soilSampleResultRepository.save(iterator.toSample(iterator, report.getId()));

			for (ReportElementsDTO elements : iterator.getElements()) {

				try {
					ElementDefaultValue elementDefaults = elementDefaultValueRepository
							.findByName(elements.getElementName(), sample.getReport().getId()).get();
					elements.setDefaults(elementDefaults);
				} catch (Exception e) {
					// TODO: handle exception
				}

				elementValueRepository.save(elements.toElementValue(elements, sample.getId()));
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

	public Iterable<ReportDTO> findReports() {

		Iterable<Report> listReports = reportRepository.findAll();

		List<ReportDTO> reportDTOList = new ArrayList<ReportDTO>();

		for (Report report : listReports) {
			ReportDTO reportDTO = new ReportDTO(report, false);
			reportDTOList.add(reportDTO);
		}

		return reportDTOList;
	}

}
