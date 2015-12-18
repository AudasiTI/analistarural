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
import br.com.analistarural.domain.entity.product.ChemicalElement;
import br.com.analistarural.domain.entity.product.Feedstock;
import br.com.analistarural.domain.entity.product.Fertilizer;
import br.com.analistarural.domain.entity.product.Fertilizer.Type;
import br.com.analistarural.domain.entity.product.Source;
import br.com.analistarural.domain.repository.product.SourceRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class FertilizerRepositoryTest {

	@Autowired
	private FertilizerRepository fertilizerRepository;
	
	@Autowired 
	private SourceRepository sourceRepository;
	
	
	@Autowired
	private FeedstockRepository feedstockRepository;
	
	
	@Autowired
	private ChemicalElementRepository chemicalElementRepository;
	
	
	
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

		assertThat(fertilizerRepository.findByIdFertilizer(fertilizer1.getIdFertilizer()).isPresent(), is(true));
		assertThat(fertilizerRepository.findByIdFertilizer(fertilizer2.getIdFertilizer()).isPresent(), is(true));
	}
	
	
	
	
	private Fertilizer createFertilizer(){
		Fertilizer fertilizer = new Fertilizer();
		List<Feedstock> feedstocks = (List<Feedstock>) feedstockRepository.findAll();
		List<Source> sources = (List<Source>) sourceRepository.findAll();
		List<ChemicalElement> chemicalElements = (List<ChemicalElement>) chemicalElementRepository.findAll();
		fertilizer.setTypeFertilizer(Type.MINERAL);
		fertilizer.setSource(sources.get(0));
		fertilizer.setFeedstock(feedstocks.get(0));
		fertilizer.setChemicalElement(chemicalElements.get(0));
		
		return fertilizer;
		
		
	}
}
