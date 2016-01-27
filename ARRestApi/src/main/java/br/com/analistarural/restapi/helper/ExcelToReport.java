package br.com.analistarural.restapi.helper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import br.com.analistarural.domain.dto.ReportDTO;
import br.com.analistarural.domain.dto.ReportElementsDTO;
import br.com.analistarural.domain.dto.SampleDTO;

public final class ExcelToReport {

	/**
	 * 
	 */

	public static StringBuilder validateExcelFile(String[][] file) {

		StringBuilder errors = new StringBuilder();

		if (!file[0][0].contentEquals("Laboratório Exata - Hoff & Brait Ltda. - www.labexata.com.br")) {
			errors.append("A autoria do arquivo não foi confirmada");
		} else if (!file[2][0].contentEquals("Email Cliente:")) {
			errors.append("E-mail do cliente ausente");
		} else if (!file[3][0].contentEquals("Email Solicitante:")) {
			errors.append("E-mail do solicitante ausente");
		} else if (!file[5][0].contentEquals("Lab")) {
			errors.append("O formato do arquivo não parece ser válido.");
		}
		return errors;
	}

	public static ReportDTO toReportDTO(String[][] file) {

		ReportDTO report = new ReportDTO();

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		// try {
		// report.setGenerationDate(df.parse(file[4][2]));
		// } catch (ParseException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		if (file[6][10].contentEquals("ph CaCl2")) {

			report.setCode(file[7][8]);
			report.setFarm(file[7][4]);
			report.setCity(file[7][5]);
			report.setSoilReport(true);
			report.setPrimaryEmail(file[3][1]);
			report.setSecondaryEmail(file[2][1]);

			for (int row = 7; row < file.length; row++) {

				SampleDTO sample = new SampleDTO();
				sample.setCrop(file[row][6]);
				sample.setCustomerElementIdent(file[row][1]);
				sample.setField(file[row][9]);
				sample.setTipoAnalise(file[row][7]);

				String unit = "";

				for (int col = 10; col < 44; col++) {
					ReportElementsDTO elements = new ReportElementsDTO();

					if (!(file[4][col] == null)) {
						unit = file[4][col];
					}

					elements.setElementUnit(unit);
					elements.setElementExtractor(file[5][col]);
					elements.setElementName(file[6][col]);
					try {
						BigDecimal bd = new BigDecimal(file[row][col]);
						bd = bd.setScale(2, RoundingMode.HALF_UP);
						elements.setMeasuredValue(bd.toString());
						System.out.println(bd.toString());
					} catch (Exception e) {
						elements.setMeasuredValue(file[row][col]);
					}

					sample.getElements().add(elements);

				}
				report.getSamples().add(sample);
			}
		} else {

			report.setCode(file[6][6]);
			report.setFarm(file[6][2]);
			report.setCity(file[6][3]);
			report.setPrimaryEmail(file[2][1]);
			report.setSecondaryEmail(file[3][1]);
			report.setSoilReport(false);

			for (int row = 6; row < file.length; row++) {

				SampleDTO sample = new SampleDTO();
				sample.setCrop(file[row][4]);
				sample.setCustomerElementIdent(file[row][1]);
				sample.setTipoAnalise(file[row][5]);

				String unit = "";

				for (int col = 7; col < 20; col++) {
					ReportElementsDTO elements = new ReportElementsDTO();

					if (!file[3][col].trim().isEmpty()) {
						unit = file[3][col];
					}

					elements.setElementUnit(unit);
					elements.setElementExtractor(file[4][col]);
					elements.setElementName(file[5][col]);

					try {
						BigDecimal bd = new BigDecimal(file[row][col]);
						bd = bd.setScale(2, RoundingMode.HALF_UP);
						elements.setMeasuredValue(bd.toString());
						System.out.println(bd.toString());
					} catch (Exception e) {
						elements.setMeasuredValue(file[row][col]);
					}

					// elements.setMeasuredValue(file[row][col]);
					sample.getElements().add(elements);
				}
				report.getSamples().add(sample);
			}
		}

		return report;
	}
}
