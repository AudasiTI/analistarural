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
import br.com.analistarural.domain.entity.activity.Activity;
import br.com.analistarural.domain.entity.activity.ActivityType;
import br.com.analistarural.domain.entity.field.Field;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class ActivityRepositoryTest {

	@Autowired
	private FieldRepository fieldRepository;

	@Autowired
	private ActivityRepository activityRepository;

	@Autowired
	private ActivityTypeRepository activityTypeRepository;

	@Test
	@Transactional
	@Rollback(false)
	public void saveActivityTest() {

		Activity a = activityRepository.save(createActivityTest());
		assertThat(activityRepository.findById(a.getId()).isPresent(), is(true));
	}

	private Activity createActivityTest() {

		Optional<Field> f = fieldRepository.findById((long) 10);

		Optional<ActivityType> at = activityTypeRepository.findById((long) 1);

		Activity a = new Activity();
		a.setActivityType(at.get());
		a.setField(f.get());
		a.setCost((long) 200.00);
		return a;
	}

}
