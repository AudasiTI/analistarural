package br.com.analistarural.restapi.service.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.entity.report.Report;
import br.com.analistarural.domain.repository.report.ReportRepository;

@Service
@Transactional
public class ReportService {

	@Autowired
	private ReportRepository reportRepository;

	public Iterable<Report> findAll() {
		return reportRepository.findAll();
	}

	@Transactional(readOnly = false)
	public void save(Report report) {
		reportRepository.save(report);
	}

	public void delete(Long id) {
		reportRepository.delete(id);
	}

}
