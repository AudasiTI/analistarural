package br.com.analistarural.domain.repository.product;


import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

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
	FeedstockRepository feedstockRepository;
	
	
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
		//Seed seed2 = seedRepository.save(createSeed());

		assertThat(seedRepository.findByIdSeed(seed1.getIdSeed()).isPresent(), is(true));
		//assertThat(seedRepository.findById(seed2.getId()).isPresent(), is(true));
	}
	
	
	
	
	private Seed createSeed(){
		Seed seed  = new Seed();
		List<Feedstock> feedstocks = (List<Feedstock>) feedstockRepository.findAll();
		List<Variety> varietys = (List<Variety>) varietyRepository.findAll();
		seed.setFeedstock(feedstocks.get(0));
		seed.setVariety(varietys.get(0));
		return seed;
		
		
	}
}
