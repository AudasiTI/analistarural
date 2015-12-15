package br.com.analistarural.restapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.analistarural.domain.dto.ReportDTO;
import br.com.analistarural.restapi.service.report.ReportService;

@RestController
@RequestMapping(value = "/api", produces = { "application/json;charset=UTF-8" })
public class ReportController {

	@Autowired
	private ReportService reportService;

	// @Secured("ROLE_ADMIN")
	// @RequestMapping(value = "/reports", method = RequestMethod.GET, consumes
	// = MediaType.APPLICATION_JSON_VALUE)
	// public @ResponseBody Iterable<Report> getReports() {
	// return reportService.findAll();
	// }

	@RequestMapping(value = "/report", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveReportFarm(@Valid @RequestBody ReportDTO reportDTO) {
		reportService.save(reportDTO);
	}

	@RequestMapping(value = "/reports", method = RequestMethod.GET)
	public @ResponseBody Iterable<ReportDTO> getReportsByEmail(@RequestParam("email") String email) {
		return (Iterable<ReportDTO>) reportService.findReportsByEmail(email);
	}

}
