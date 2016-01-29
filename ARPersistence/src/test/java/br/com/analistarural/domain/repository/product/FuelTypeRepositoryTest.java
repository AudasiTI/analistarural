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
import br.com.analistarural.domain.entity.product.FuelType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class FuelTypeRepositoryTest {

	@Autowired
	private FuelTypeRepository fuelTypeRepository;
	
	
	@Autowired
	@Test
	public void connect() {
		assertThat(fuelTypeRepository, notNullValue());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void repositoryFlowTest() {
		FuelType fuelType1 = fuelTypeRepository.save(createFuelType());
		//Measurement measurement2 = measurementRepository.save(createMeasurement());

		assertThat(fuelTypeRepository.findByIdFuelType(fuelType1.getIdFuelType()).isPresent(), is(true));
		//assertThat(measurementRepository.findByIdMeasurement(measurement2.getIdMeasurement()).isPresent(), is(true));
	}
	
	
	private FuelType createFuelType() {
		FuelType fuelType = new FuelType();
		fuelType.setName("Gasolina");
		return fuelType;
	}
	
	

}
