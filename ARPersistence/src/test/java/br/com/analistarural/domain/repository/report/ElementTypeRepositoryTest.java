package br.com.analistarural.domain.repository.report;

import static org.hamcrest.CoreMatchers.notNullValue;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.config.ApplicationConfig;
import br.com.analistarural.domain.entity.report.ElementType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class ElementTypeRepositoryTest {

	@Autowired
	private ElementTypeRepository elementTypeRepository;

	@Autowired
	@Test
	public void connect() {
		assertThat(elementTypeRepository, notNullValue());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void saveElementTest() {

		ElementType et = elementTypeRepository.save(createElementTypeTest());

		assertThat(elementTypeRepository.findById(et.getId()).isPresent(), is(true));
	}

	private ElementType createElementTypeTest() {
		ElementType e = new ElementType();
		e.setDescription("ElementoTeste");
		return e;
	}
}
