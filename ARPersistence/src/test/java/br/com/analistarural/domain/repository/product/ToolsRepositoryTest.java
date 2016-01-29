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
import br.com.analistarural.domain.entity.product.Consumption;
import br.com.analistarural.domain.entity.product.Tools;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class ToolsRepositoryTest {


	@Autowired
	private ToolsRepository toolsRepository;
	
	@Autowired
	private ConsumptionRepository consumptionRepository;
	
	
	@Autowired
	@Test
	public void connect() {
		assertThat(toolsRepository, notNullValue());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void repositoryFlowTest() {
		Tools tools1 = toolsRepository.save(createTools());
		//Fertilizer fertilizer2 = fertilizerRepository.save(createFertilizer());

		assertThat(toolsRepository.findByIdTools(tools1.getIdTools()).isPresent(), is(true));
		//assertThat(fertilizerRepository.findByIdFertilizer(fertilizer2.getIdFertilizer()).isPresent(), is(true));
	}
	
	
	private Tools createTools(){
		Tools tools = new Tools();
		List<Consumption> consumptions = (List<Consumption>) consumptionRepository.findAll();
		tools.setConsumption(consumptions.get(0));
		return tools;
		
		
	}

}
