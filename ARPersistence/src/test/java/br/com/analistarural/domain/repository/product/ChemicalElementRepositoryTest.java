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
import br.com.analistarural.domain.entity.product.ChemicalElement;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class ChemicalElementRepositoryTest {	
	
	@Autowired
	private ChemicalElementRepository chemicalElementRepository;
	
	
	@Autowired
	@Test
	public void connect() {
		assertThat(chemicalElementRepository, notNullValue());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void repositoryFlowTest() {
		ChemicalElement chemicalElement1 = chemicalElementRepository.save(createChemicalElement());
		//Fertilizer fertilizer2 = chemicalElementRepository.save(createFertilizer());

		assertThat(chemicalElementRepository.findByIdChemicalElement(chemicalElement1.getIdChemicalElement()).isPresent(), is(true));
		//assertThat(chemicalElementRepository.findByIdFertilizer(fertilizer2.getIdFertilizer()).isPresent(), is(true));
	}
	
	
	
	
	private ChemicalElement createChemicalElement(){
		ChemicalElement chemicalELement = new ChemicalElement();
		chemicalELement.setName("Potash");
		chemicalELement.setPercentage(10.0);
		return chemicalELement;
		
		
	}

}
