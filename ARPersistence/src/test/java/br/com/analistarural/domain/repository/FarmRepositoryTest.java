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
import br.com.analistarural.domain.entity.account.SystemAccount;
import br.com.analistarural.domain.entity.field.Farm;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class FarmRepositoryTest {

	@Autowired
	private FarmRepository farmRepository;

	@Autowired
	private SystemAccountRepository systemAccountRepository;

	@Test
	@Transactional
	@Rollback(false)
	public void saveFarmTest() {

		Farm f = farmRepository.save(createFarmTest());
		assertThat(farmRepository.findById(f.getId()).isPresent(), is(true));
	}

	private Farm createFarmTest() {
		Optional<SystemAccount> sa = systemAccountRepository.findById((long) 1);

		Farm farm = new Farm();
		farm.setName("Fazenda Jataí");
		farm.setSystemAccount(sa.get());
		return farm;
	}

}
