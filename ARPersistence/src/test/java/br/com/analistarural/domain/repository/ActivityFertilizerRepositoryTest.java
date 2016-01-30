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
import br.com.analistarural.domain.entity.activity.ActivityFertilizer;
import br.com.analistarural.domain.entity.product.Fertilizer;
import br.com.analistarural.domain.repository.product.FertilizerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class ActivityFertilizerRepositoryTest {

	@Autowired
	private ActivityRepository activityRepository;

	@Autowired
	private ActivityFertilizerRepository activityFertilizerRepository;

	@Autowired
	private FertilizerRepository fertilizerRepository;

	@Test
	@Transactional
	@Rollback(false)
	public void saveActivityFertilizerTest() {

//		ActivityFertilizer af = activityFertilizerRepository
//				.save(createActivityFertilizerTest());
//		
//		assertThat(activityFertilizerRepository.findById(af.getId())
//				.isPresent(), is(true));
	}

	private ActivityFertilizer createActivityFertilizerTest() {

		Optional<Activity> a = activityRepository.findById((long) 51);

		Optional<Fertilizer> f = fertilizerRepository.findByIdFertilizer((long) 40);

		ActivityFertilizer af = new ActivityFertilizer();
		af.setActivity(a.get());
		af.setCost(200.50);
		af.setFertilizer(f.get());
		af.setQuantity((long) 500);
		return af;
	}
}
