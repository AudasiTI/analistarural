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
import br.com.analistarural.domain.entity.product.ChemicalElement;
import br.com.analistarural.domain.entity.product.Defensive;
import br.com.analistarural.domain.entity.product.DefensiveType;
import br.com.analistarural.domain.entity.product.Feedstock;
import br.com.analistarural.domain.entity.product.ProducedSeed;
import br.com.analistarural.domain.entity.product.ProductFinished;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class ProducedSeedRepositoryTest {

	@Autowired
	private ProducedSeedRepository producedSeedRepository;
	
	@Autowired
	ProductFinishedRepository productFinishedRepository;
	
	
	@Autowired
	@Test
	public void connect() {
		assertThat(producedSeedRepository, notNullValue());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void repositoryFlowTest() {
		ProducedSeed producedSeed1 = producedSeedRepository.save(createProducedSeed());
		assertThat(producedSeedRepository.findByIdProducedSeed(producedSeed1.getIdProducedSeed()).isPresent(), is(true));
	}
	
	
	private ProducedSeed createProducedSeed(){

		ProducedSeed producedSeed = new ProducedSeed();
		List<ProductFinished> productsFinisheds = (List<ProductFinished>) productFinishedRepository.findAll();
		producedSeed.setDescriptionType("Soja da Primeira safra");
		producedSeed.setProductFinished(productsFinisheds.get(0));
	
		return producedSeed;
	}

	
	
	

}
