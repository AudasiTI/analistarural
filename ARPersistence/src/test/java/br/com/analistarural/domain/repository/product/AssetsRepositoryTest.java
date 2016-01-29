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
import br.com.analistarural.domain.entity.product.Assets;
import br.com.analistarural.domain.entity.product.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class AssetsRepositoryTest {

	@Autowired
	private AssetsRepository assetsRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	@Test
	public void connect() {
		assertThat(assetsRepository, notNullValue());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void repositoryFlowTest() {
		Assets assets1 = assetsRepository.save(createAssets());
		//Measurement measurement2 = measurementRepository.save(createMeasurement());

		assertThat(assetsRepository.findByIdAssets(assets1.getIdAssets()).isPresent(), is(true));
		//assertThat(measurementRepository.findByIdMeasurement(measurement2.getIdMeasurement()).isPresent(), is(true));
	}
	
	
	private Assets createAssets() {
		Assets assets = new Assets();
		List<Product> products = (List<Product>) productRepository.findAll();
		assets.setPatrimony("Patrimonio 1");
		assets.setProduct(products.get(0));
		return assets;
	}
	

}
