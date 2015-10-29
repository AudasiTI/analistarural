package br.com.analistarural.domain.repository;

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
import br.com.analistarural.domain.entity.account.SystemAccount;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class SystemAccountRepositoryTest {

	@Autowired
	private SystemAccountRepository systemAccountRepository;

	@Test
	@Transactional
	@Rollback(true)
	public void saveSystemAccountTest() {

		SystemAccount systemAccount = new SystemAccount();

		SystemAccount sa = systemAccountRepository.save(systemAccount);

		assertThat(systemAccountRepository.findById(sa.getId()).isPresent(),
				is(true));
	}

}
