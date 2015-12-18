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
import br.com.analistarural.domain.entity.product.Source;
import br.com.analistarural.domain.repository.product.SourceRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class SourceRepositoryTest {

	@Autowired
	private SourceRepository sourceRepository;

	@Autowired
	@Test
	public void connect() {
		assertThat(sourceRepository, notNullValue());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void repositoryFlowTest() {
		Source source1 = sourceRepository.save(createSource());
		Source source2 = sourceRepository.save(createSource());

		assertThat(sourceRepository.findById(source1.getId()).isPresent(), is(true));
		assertThat(sourceRepository.findById(source2.getId()).isPresent(), is(true));
	}
	
	
	private Source createSource() {
		Source s = new Source();
		s.setName("Frango");
		return s;
	}
	
	
}
