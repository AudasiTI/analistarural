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
import br.com.analistarural.domain.entity.product.DefensiveType;
import br.com.analistarural.domain.repository.product.DefensiveTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class DefensiveTypeRepositoryTest {


	@Autowired
	private DefensiveTypeRepository defensiveTypeRepository;

	@Autowired
	@Test
	public void connect() {
		assertThat(defensiveTypeRepository, notNullValue());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void repositoryFlowTest() {
		DefensiveType defensiveType1 = defensiveTypeRepository.save(createDefensiveType());
		DefensiveType defensiveType2 = defensiveTypeRepository.save(createDefensiveType());

		assertThat(defensiveTypeRepository.findByIdDefensiveType(defensiveType1.getIdDefensiveType()).isPresent(), is(true));
		assertThat(defensiveTypeRepository.findByIdDefensiveType(defensiveType2.getIdDefensiveType()).isPresent(), is(true));
	}
	
	
	private DefensiveType createDefensiveType() {
		DefensiveType ct = new DefensiveType();
		ct.setName("Fungicida");
		return ct;
	}

	
	
	
}
