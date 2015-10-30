package br.com.analistarural.domain.repository.product;

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
import br.com.analistarural.domain.entity.User;
import br.com.analistarural.domain.entity.product.ProductCategory;
import br.com.analistarural.domain.repository.product.ProductCategoryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class ProductCategoryRepositoryTest {
	
	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Autowired
	@Test
	public void connect() {
		assertThat(productCategoryRepository, notNullValue());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void repositoryFlowTest() {
		ProductCategory productCategory1 = productCategoryRepository.save(createProductCategory());
		ProductCategory productCategory2 = productCategoryRepository.save(createProductCategory());

		assertThat(productCategoryRepository.findById(productCategory1.getId()).isPresent(), is(true));
		assertThat(productCategoryRepository.findById(productCategory2.getId()).isPresent(), is(true));
	}
	
	
	private ProductCategory createProductCategory() {
		ProductCategory pc = new ProductCategory();
		pc.setDescription("00 - Mercadoria para revenda");
		return pc;
	}

}
