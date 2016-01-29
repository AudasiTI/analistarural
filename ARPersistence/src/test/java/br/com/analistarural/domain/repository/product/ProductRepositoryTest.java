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
import br.com.analistarural.domain.entity.product.Measurement;
import br.com.analistarural.domain.entity.product.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private MeasurementRepository measurementRepository;
	

	@Autowired
	@Test
	public void connect() {
		assertThat(productRepository, notNullValue());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void repositoryFlowTest() {
		Product product1 = productRepository.save(createProduct());
		//Measurement measurement2 = measurementRepository.save(createMeasurement());

		assertThat(productRepository.findByIdProduct(product1.getIdProduct()).isPresent(), is(true));
		//assertThat(measurementRepository.findByIdMeasurement(measurement2.getIdMeasurement()).isPresent(), is(true));
	}
	
	
	private Product createProduct() {
		Product product = new Product();
		List<Measurement> measurements = (List<Measurement>) measurementRepository.findAll();
		product.setName("Fertilizante Especial");
		product.setMeasurement(measurements.get(0));
		return product;
	}

}
