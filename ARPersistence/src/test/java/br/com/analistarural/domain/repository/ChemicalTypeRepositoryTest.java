package br.com.analistarural.domain.repository;

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
import br.com.analistarural.domain.entity.product.ChemicalType;
import br.com.analistarural.domain.repository.product.ChemicalTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class ChemicalTypeRepositoryTest {


	@Autowired
	private ChemicalTypeRepository chemicalTypeRepository;

	@Autowired
	@Test
	public void connect() {
		assertThat(chemicalTypeRepository, notNullValue());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void repositoryFlowTest() {
		ChemicalType chemicalType1 = chemicalTypeRepository.save(createChemicalType());
		ChemicalType chemicalType2 = chemicalTypeRepository.save(createChemicalType());

		assertThat(chemicalTypeRepository.findById(chemicalType1.getId()).isPresent(), is(true));
		assertThat(chemicalTypeRepository.findById(chemicalType2.getId()).isPresent(), is(true));
	}
	
	
	private ChemicalType createChemicalType() {
		ChemicalType ct = new ChemicalType();
		ct.setName("Fungicida");
		return ct;
	}

	
	
	
}
