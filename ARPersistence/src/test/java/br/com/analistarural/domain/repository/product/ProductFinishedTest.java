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
import br.com.analistarural.domain.entity.product.Product;
import br.com.analistarural.domain.entity.product.ProductFinished;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class ProductFinishedTest {

	@Autowired
	ProductFinishedRepository productFinishedRepository;
	
	@Autowired
	ProductRepository productRepository;
	

	@Autowired
	@Test
	public void connect() {
		assertThat(productFinishedRepository, notNullValue());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void repositoryFlowTest() {
		ProductFinished productFinished = productFinishedRepository.save(createProductFinished());
		//Measurement measurement2 = measurementRepository.save(createMeasurement());

		assertThat(productFinishedRepository.findByIdProductFinished(productFinished.getIdidProductFinished()).isPresent(), is(true));
		//assertThat(measurementRepository.findByIdMeasurement(measurement2.getIdMeasurement()).isPresent(), is(true));
	}
	
	
	private ProductFinished createProductFinished() {
		ProductFinished productFinished = new ProductFinished();
		List<Product> products = (List<Product>) productRepository.findAll();
		productFinished.setAverageCost(22.0);
		productFinished.setQuantity(10.0);
		productFinished.setProduct(products.get(0));
		return productFinished;
	}
	
}
