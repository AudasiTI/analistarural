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
import br.com.analistarural.domain.entity.product.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class ConsumptionRepositoryTest {

	@Autowired
	private ConsumptionRepository consumptionRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	@Test
	public void connect() {
		assertThat(consumptionRepository, notNullValue());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void repositoryFlowTest() {
		Consumption consumption1 = consumptionRepository.save(createConsumption());
		//Measurement measurement2 = measurementRepository.save(createMeasurement());

		assertThat(consumptionRepository.findByIdConsumption(consumption1.getIdConsumption()).isPresent(), is(true));
		//assertThat(measurementRepository.findByIdMeasurement(measurement2.getIdMeasurement()).isPresent(), is(true));
	}
	
	
	private Consumption createConsumption() {
		Consumption consumption = new Consumption();
		List<Product> products = (List<Product>) productRepository.findAll();
		
		consumption.setUnityValue(40.0);
		consumption.setQuantity(10.0);
		consumption.setProduct(products.get(0));
		return consumption;
	}

}
