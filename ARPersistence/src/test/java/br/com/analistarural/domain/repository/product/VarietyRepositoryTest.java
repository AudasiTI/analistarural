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
import br.com.analistarural.domain.entity.product.Variety;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class VarietyRepositoryTest {

	@Autowired
	private VarietyRepository varietyRepository;

	@Autowired
	@Test
	public void connect() {
		assertThat(varietyRepository, notNullValue());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void repositoryFlowTest() {
		Variety variety1 = varietyRepository.save(createVariety());
		//Variety variety2 = varietyRepository.save(createVariety());

		assertThat(varietyRepository.findByIdVariety(variety1.getIdVariety()).isPresent(), is(true));
		//assertThat(varietyRepository.findById(variety2.getId()).isPresent(), is(true));
	}
	
	
	private Variety createVariety() {
		Variety variety = new Variety();
		variety.setName("RS5019");
		return variety;
	}
	
}
