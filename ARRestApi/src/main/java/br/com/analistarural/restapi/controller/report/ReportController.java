package br.com.analistarural.restapi.controller.report;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.analistarural.domain.dto.ReportDTO;
import br.com.analistarural.domain.entity.report.Report;
import br.com.analistarural.restapi.helper.ExcelToReport;
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

	@RequestMapping(value = "/reports", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
	public @ResponseBody Map<String, String> saveReports(
			@RequestBody String[][] relatorio) {

		Map<String, String> map = new HashMap<String, String>();

		try {
			reportService.save(ExcelToReport.toReportDTO(relatorio));
			map.put("Message", "Laudo importado com sucesso");
		} catch (Exception e) {
			map.put("Message", e.getMessage());
			// TODO: handle exception
		}
		return map;
	}

	@RequestMapping(value = "/reports/{email:.+}", method = RequestMethod.GET)
	public @ResponseBody Iterable<ReportDTO> getReportsByEmail(
			@PathVariable("email") String emailParam) {
		return (Iterable<ReportDTO>) reportService
				.findReportsByEmail(emailParam);
	}

	@RequestMapping(value = "/reports", method = RequestMethod.GET)
	public @ResponseBody Iterable<ReportDTO> getReports() {
		return (Iterable<ReportDTO>) reportService.findReports();
	}

	@RequestMapping(value = "/reports/{report_id}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteReport(
			@PathVariable("report_id") Long report_id) {
		reportService.delete(report_id);
		return "Registro excluído com sucesso.";
	}

	@RequestMapping(value = "/reports/{report_id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateReport(@Valid @RequestBody ReportDTO reportDTO) {
		reportService.updateReport(reportDTO);
		return "Registro atualizado com sucesso.";
	}

}
