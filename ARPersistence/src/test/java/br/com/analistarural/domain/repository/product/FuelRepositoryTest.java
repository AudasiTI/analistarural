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
import br.com.analistarural.domain.entity.product.Fuel;
import br.com.analistarural.domain.entity.product.FuelType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class FuelRepositoryTest {

	@Autowired
	private FuelRepository fuelRepository;
	
	@Autowired
	private ConsumptionRepository consumptionRepository;
	

	@Autowired
	private FuelTypeRepository fuelTypeRepository;
	
	@Autowired
	@Test
	public void connect() {
		assertThat(fuelRepository, notNullValue());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void repositoryFlowTest() {
		Fuel fuel1 = fuelRepository.save(createFuel());
		//Measurement measurement2 = measurementRepository.save(createMeasurement());

		assertThat(fuelRepository.findByIdFuel(fuel1.getIdFuel()).isPresent(), is(true));
		//assertThat(measurementRepository.findByIdMeasurement(measurement2.getIdMeasurement()).isPresent(), is(true));
	}
	
	
	private Fuel createFuel() {
		Fuel fuel = new Fuel();
		List<Consumption> consumptions = (List<Consumption>) consumptionRepository.findAll();
		List<FuelType> fuelsTypes = (List<FuelType>) fuelTypeRepository.findAll();
		fuel.setCodeANP("1234567");
		fuel.setDescriptionANP("Gasolina T1");
		fuel.setConsumption(consumptions.get(0));
		fuel.setFuelType(fuelsTypes.get(0));
		return fuel;
	}
	
}
