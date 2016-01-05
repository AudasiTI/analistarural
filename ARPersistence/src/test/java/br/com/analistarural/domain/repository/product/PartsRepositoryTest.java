package br.com.analistarural.domain.repository.product;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.config.ApplicationConfig;
import br.com.analistarural.domain.entity.product.Consumption;
import br.com.analistarural.domain.entity.product.Parts;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class PartsRepositoryTest {


	@Autowired
	private PartsRepository partsRepository;
	
	@Autowired
	private ConsumptionRepository consumptionRepository;
	
	@Autowired
	@Test
	public void connect() {
		assertThat(partsRepository, notNullValue());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void repositoryFlowTest() {
		Parts parts1 = partsRepository.save(createParts());
		//Measurement measurement2 = measurementRepository.save(createMeasurement());

		assertThat(partsRepository.findByIdParts(parts1.getIdParts()).isPresent(), is(true));
		//assertThat(measurementRepository.findByIdMeasurement(measurement2.getIdMeasurement()).isPresent(), is(true));
	}
	
	
	private Parts createParts() {
		Parts parts = new Parts();
		List<Consumption> consumptions = (List<Consumption>) consumptionRepository.findAll();
		parts.setConsumption(consumptions.get(0));
		parts.setCode2("Code2 123456");
		return parts;
	}

}
