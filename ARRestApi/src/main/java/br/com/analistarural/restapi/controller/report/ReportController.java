package br.com.analistarural.restapi.controller.report;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.analistarural.domain.entity.report.Report;
import br.com.analistarural.restapi.service.report.ReportService;

@RestController
@RequestMapping(value = "/api", produces = { "application/json;charset=UTF-8" })
public class ReportController {

	@Autowired
	private ReportService reportService;

	@RequestMapping(value = "/reports", method = RequestMethod.GET)
	public Iterable<Report> getReports() {
		return reportService.findAll();
	}

	@RequestMapping(value = "/report", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveReport(@Valid @RequestBody Report report) {
		reportService.save(report);
	}

}
