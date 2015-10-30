package br.com.analistarural.domain.repository;

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
import br.com.analistarural.domain.entity.product.ProductType;
import br.com.analistarural.domain.repository.product.ProductTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class ProductTypeRepositoryTest {

	@Autowired
	private ProductTypeRepository productTypeRepository;

	@Autowired
	@Test
	public void connect() {
		assertThat(productTypeRepository, notNullValue());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void repositoryFlowTest() {
		ProductType productType1 = productTypeRepository.save(createProductType());
		ProductType productType2 = productTypeRepository.save(createProductType());

		assertThat(productTypeRepository.findById(productType1.getId()).isPresent(), is(true));
		assertThat(productTypeRepository.findById(productType2.getId()).isPresent(), is(true));
	}
	
	
	private ProductType createProductType() {
		ProductType pt = new ProductType();
		pt.setDescription("Fertilizantes");
		return pt;
	}

	
	
}
