package br.com.analistarural.domain.repository.product;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.config.ApplicationConfig;
import br.com.analistarural.domain.entity.product.Feedstock;
import br.com.analistarural.domain.entity.product.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class FeedstockRepositoryTest {

	@Autowired
	private FeedstockRepository feedstockRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	@Test
	public void connect() {
		assertThat(feedstockRepository, notNullValue());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void repositoryFlowTest() {
		Feedstock feedstock1 = feedstockRepository.save(createFeedstock());
		//Measurement measurement2 = measurementRepository.save(createMeasurement());

		assertThat(feedstockRepository.findByIdFeedstock(feedstock1.getIdFeedstock()).isPresent(), is(true));
		//assertThat(measurementRepository.findByIdMeasurement(measurement2.getIdMeasurement()).isPresent(), is(true));
	}
	
	
	private Feedstock createFeedstock() {
		Feedstock feedstock = new Feedstock();
		List<Product> products = (List<Product>) productRepository.findAll();
		feedstock.setBrand("Pionner");
		feedstock.setCost(30.0);
		feedstock.setAverageCost(30.0);
		feedstock.setDescription("Um produto inovador para soja");
		feedstock.setQuantity(10.0);
		feedstock.setProduct(products.get(0));
		return feedstock;
	}
	

}
