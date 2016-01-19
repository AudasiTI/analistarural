package br.com.analistarural.restapi.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import br.com.analistarural.domain.dto.ReportDTO;
import br.com.analistarural.domain.dto.ReportElementsDTO;
import br.com.analistarural.domain.dto.SampleDTO;
import br.com.analistarural.domain.entity.report.SoilSampleResult;

public final class ExcelToReport {

	public static ReportDTO toReportDTO(String[][] file) {

		ReportDTO report = new ReportDTO();

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		// try {
		// report.setGenerationDate(df.parse(file[4][2]));
		// } catch (ParseException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		if (file[4][7].contentEquals("Q,(Pres)(-MI)")) {

			report.setCode(file[4][8]);
			report.setFarm(file[4][4]);
			report.setCity(file[4][5]);
			// report.setEmail(file[2][1]);
			// report.setSecondaryEmail(file[3][1]);

			for (int row = 4; row < file.length; row++) {

				SampleDTO sample = new SampleDTO();
				sample.setCrop(file[row][6]);
				sample.setCustomerElementIdent(file[row][1]);
				sample.setField(file[row][9]);
				sample.setTipoAnalise(file[row][7]);

				for (int col = 10; col < 44; col++) {
					ReportElementsDTO elements = new ReportElementsDTO();
					elements.setElementName(file[3][col]);
					elements.setMeasuredValue(file[row][col]);
					sample.getElements().add(elements);

				}
				report.getSamples().add(sample);
			}
		} else if (file[6][5].contentEquals("COMPLETA (N,P,K,Ca,Mg,S,B,Cu,Fe,Mn,Zn)")) {

			report.setCode(file[6][6]);
			report.setFarm(file[6][2]);
			report.setCity(file[6][3]);
			report.setEmail(file[2][1]);
			report.setSecondaryEmail(file[3][1]);

			for (int row = 6; row < file.length; row++) {

				SampleDTO sample = new SampleDTO();
				sample.setCrop(file[row][4]);
				sample.setCustomerElementIdent(file[row][1]);
				sample.setTipoAnalise(file[row][5]);

				for (int col = 7; col < 20; col++) {
					ReportElementsDTO elements = new ReportElementsDTO();
					elements.setElementName(file[5][col]);
					elements.setMeasuredValue(file[row][col]);
					sample.getElements().add(elements);
				}
				report.getSamples().add(sample);
			}
		}

		return report;
	}
}
