package br.com.analistarural.domain.repository;

import static org.hamcrest.CoreMatchers.is;
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
import br.com.analistarural.domain.entity.field.Farm;
import br.com.analistarural.domain.entity.field.Field;
import br.com.analistarural.domain.entity.field.FieldGroup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class FieldRepositoryTest {

	@Autowired
	private FarmRepository farmRepository;

	@Autowired
	private FieldRepository fieldRepository;

	@Autowired
	private FieldGroupRepository fieldGroupRepository;

	@Test
	@Transactional
	@Rollback(false)
	public void saveFieldTest() {

		Field f1 = fieldRepository.save(createFieldTest());
		Field f2 = fieldRepository.save(createFieldWithFieldGroupTest());

		assertThat(fieldRepository.findById(f1.getId()).isPresent(), is(true));
		assertThat(fieldRepository.findById(f2.getId()).isPresent(), is(true));
	}

	private Field createFieldTest() {
		Optional<Farm> farm = farmRepository.findById((long) 1);

		Field f = new Field();
		f.setName("Area10");
		f.setFarm(farm.get());
		return f;
	}

	private Field createFieldWithFieldGroupTest() {
		Optional<Farm> farm = farmRepository.findById((long) 1);
		Optional<FieldGroup> fieldGroup = fieldGroupRepository
				.findById((long) 1);

		Field f = new Field();
		f.setName("Area10");
		f.setFarm(farm.get());
		f.setFieldGroup(fieldGroup.get());
		return f;
	}
}
