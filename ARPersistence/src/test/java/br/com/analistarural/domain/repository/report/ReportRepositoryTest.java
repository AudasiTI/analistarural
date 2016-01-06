package br.com.analistarural.domain.repository.report;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.config.ApplicationConfig;
import br.com.analistarural.domain.entity.report.ElementType;
import br.com.analistarural.domain.entity.report.ElementValue;
import br.com.analistarural.domain.entity.report.Report;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class ReportRepositoryTest {

	@Autowired
	private ReportRepository reportRepository;

	@Autowired
	private ElementTypeRepository elementTypeRepository;

	@Autowired
	private ElementValueRepository elementValueRepository;

	@Autowired
	@Test
	public void connect() {
		assertThat(reportRepository, notNullValue());
	}

	private Report createReport() {
		Report report = new Report();
		ElementValue element1 = new ElementValue();
		ElementValue element2 = new ElementValue();
		ElementType elementType = new ElementType();
		elementType = elementTypeRepository.findByDescription("phcacl2").get();
		element1.setMeasuredValue(5.09999990463257);
		// element1.setReport(report);
		// report.getElementValues().add(element1);

		elementType = elementTypeRepository.findByDescription("phh2o").get();
		element2.setMeasuredValue(4.42000007629395);
		// element2.setReport(report);
		// report.getElementValues().add(element2);

		return report;
	}

	// @Test
	// @Transactional
	// @Rollback(true)
	// public void saveReportTest() {
	//
	// Report r = reportRepository.save(createReport());
	// assertThat(reportRepository.findById(r.getId()).isPresent(), is(true));
	//
	// //elementValueRepository.save(r.getElementValues());
	//
	// }

	// private void readExcelFile() {
	// try {
	// FileInputStream file = new FileInputStream(new
	// File("howtodoinjava_demo.xlsx"));
	//
	// // Create Workbook instance holding reference to .xlsx file
	// XSSFWorkbook workbook = new XSSFWorkbook(file);
	//
	// // Get first/desired sheet from the workbook
	// XSSFSheet sheet = workbook.getSheetAt(0);
	//
	// // Iterate through each rows one by one
	// Iterator<Row> rowIterator = sheet.iterator();
	// while (rowIterator.hasNext()) {
	// Row row = rowIterator.next();
	// // For each row, iterate through all the columns
	// Iterator<Cell> cellIterator = row.cellIterator();
	//
	// while (cellIterator.hasNext()) {
	// Cell cell = cellIterator.next();
	// // Check the cell type and format accordingly
	// switch (cell.getCellType()) {
	// case Cell.CELL_TYPE_NUMERIC:
	// System.out.print(cell.getNumericCellValue() + "t");
	// break;
	// case Cell.CELL_TYPE_STRING:
	// System.out.print(cell.getStringCellValue() + "t");
	// break;
	// }
	// }
	// System.out.println("");
	// }
	// file.close();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

}
