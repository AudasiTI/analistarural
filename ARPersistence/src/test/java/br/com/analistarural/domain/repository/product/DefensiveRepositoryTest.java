package br.com.analistarural.domain.repository.product;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.config.ApplicationConfig;
import br.com.analistarural.domain.entity.product.Defensive;
import br.com.analistarural.domain.entity.product.DefensiveType;
import br.com.analistarural.domain.entity.product.ProductCategory;
import br.com.analistarural.domain.entity.product.ProductType;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class DefensiveRepositoryTest {

	@Autowired
	private DefensiveRepository chemicalRepository;
	
	@Autowired
	DefensiveTypeRepository chemicalTypeRepository;
	
	@Autowired 
	ProductCategoryRepository productCategoryRepository;
	
	@Autowired 
	ProductTypeRepository productTypeRepository;
	
	@Autowired
	@Test
	public void connect() {
		assertThat(chemicalRepository, notNullValue());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void repositoryFlowTest() {
		Defensive defensive1 = chemicalRepository.save(createDefensive());
		Defensive defensive2 = chemicalRepository.save(createDefensive());

		//assertThat(chemicalRepository.findById(chemical1.getId()).isPresent(), is(true));
		//assertThat(chemicalRepository.findById(chemical2.getId()).isPresent(), is(true));
	}
	
	
	private Defensive createDefensive(){

		Defensive defensive = new Defensive();
		java.util.List<DefensiveType> ct = (java.util.List<DefensiveType>) chemicalTypeRepository.findAll();
		Optional<ProductType> pt = productTypeRepository.findById((long) 25);
		Optional<ProductCategory> pc = productCategoryRepository.findById((long) 37);
		
	
		return defensive;
	}

}
