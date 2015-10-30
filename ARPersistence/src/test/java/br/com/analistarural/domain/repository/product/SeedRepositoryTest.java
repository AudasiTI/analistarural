package br.com.analistarural.domain.repository.product;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.config.ApplicationConfig;
import br.com.analistarural.domain.entity.product.Seed;
import br.com.analistarural.domain.entity.product.Variety;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class SeedRepositoryTest {

	@Autowired
	private SeedRepository seedRepository;
	
	@Autowired 
	VarietyRepository varietyRepository;
	
	@Autowired
	@Test
	public void connect() {
		assertThat(seedRepository, notNullValue());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void repositoryFlowTest() {
		Seed seed1 = seedRepository.save(createSeed());
		Seed seed2 = seedRepository.save(createSeed());

		assertThat(seedRepository.findById(seed1.getId()).isPresent(), is(true));
		assertThat(seedRepository.findById(seed2.getId()).isPresent(), is(true));
	}
	
	
	
	
	private Seed createSeed(){
		Seed s  = new Seed();
		Optional<Variety> v = varietyRepository.findById((long) 3);
		s.setName("Semente de Soja");
		s.setCost(20.0);
		s.setUnity("Kilo");
		s.setVariety(v.get());
		
		return s;
		
		
	}
}
