package br.com.analistarural.domain.repository.product;

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
import static org.hamcrest.CoreMatchers.is;
import br.com.analistarural.domain.config.ApplicationConfig;
import br.com.analistarural.domain.entity.product.ChemicalElement;
import br.com.analistarural.domain.entity.product.Defensive;
import br.com.analistarural.domain.entity.product.DefensiveType;
import br.com.analistarural.domain.entity.product.Feedstock;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class DefensiveRepositoryTest {

	@Autowired
	private DefensiveRepository defensiveRepository;
	
	@Autowired
	DefensiveTypeRepository defensiveTypeRepository;
	
	@Autowired
	private FeedstockRepository feedstockRepository;
	
	
	@Autowired
	private ChemicalElementRepository chemicalElementRepository;
	
	
	
	@Autowired
	@Test
	public void connect() {
		assertThat(defensiveRepository, notNullValue());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void repositoryFlowTest() {
		Defensive defensive1 = defensiveRepository.save(createDefensive());
		assertThat(defensiveRepository.findByIdDefensive(defensive1.getIdDefensive()).isPresent(), is(true));
	}
	
	
	private Defensive createDefensive(){

		Defensive defensive = new Defensive();
		java.util.List<DefensiveType> defensiveType = (java.util.List<DefensiveType>) defensiveTypeRepository.findAll();
		List<Feedstock> feedstocks = (List<Feedstock>) feedstockRepository.findAll();
		List<ChemicalElement> chemicalElements = (List<ChemicalElement>) chemicalElementRepository.findAll();
		defensive.setRestrictUse(true);
		defensive.setDefensiveType(defensiveType.get(0));
		defensive.setFeedstock(feedstocks.get(0));
		defensive.setChemicalElement(chemicalElements.get(0));
		
	
		return defensive;
	}

}
