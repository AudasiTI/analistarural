package br.com.analistarural.domain.repository.product;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.config.ApplicationConfig;
import br.com.analistarural.domain.entity.product.Measurement;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class MeasurementRepositoryTest {

	@Autowired
	private MeasurementRepository measurementRepository;
	

	@Autowired
	@Test
	public void connect() {
		assertThat(measurementRepository, notNullValue());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void repositoryFlowTest() {
		Measurement measurement1 = measurementRepository.save(createMeasurement());
		//Measurement measurement2 = measurementRepository.save(createMeasurement());

		assertThat(measurementRepository.findByIdMeasurement(measurement1.getIdMeasurement()).isPresent(), is(true));
		//assertThat(measurementRepository.findByIdMeasurement(measurement2.getIdMeasurement()).isPresent(), is(true));
	}
	
	
	private Measurement createMeasurement() {
		Measurement measurement = new Measurement();
		measurement.setName("Unidade");
		measurement.setAbbreviation("UN");
		return measurement;
	}

}
