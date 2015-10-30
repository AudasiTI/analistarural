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
import br.com.analistarural.domain.entity.product.Fertilizer;
import br.com.analistarural.domain.entity.product.Source;
import br.com.analistarural.domain.repository.product.SourceRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class FertilizerRepositoryTest {

	@Autowired
	private FertilizerRepository fertilizerRepository;
	
	@Autowired SourceRepository sourceRepository;
	
	@Autowired
	@Test
	public void connect() {
		assertThat(fertilizerRepository, notNullValue());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void repositoryFlowTest() {
		Fertilizer fertilizer1 = fertilizerRepository.save(createFertilizer());
		Fertilizer fertilizer2 = fertilizerRepository.save(createFertilizer());

		assertThat(fertilizerRepository.findById(fertilizer1.getId()).isPresent(), is(true));
		assertThat(fertilizerRepository.findById(fertilizer2.getId()).isPresent(), is(true));
	}
	
	
	
	
	private Fertilizer createFertilizer(){
		Fertilizer f = new Fertilizer();
		Optional<Source> s = sourceRepository.findById((long) 1);
		f.setName("AgroFertilizante");
		f.setPercentualNitrogen("10");
		f.setPercentualPhosphate("12");
		f.setPercentualPotash("11");
		f.setCost(30.0);
		f.setUnity("Kilo");
		f.setSource(s.get());
		
		return f;
		
		
	}
}
