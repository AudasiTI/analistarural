package br.com.analistarural.domain.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.config.ApplicationConfig;
import br.com.analistarural.domain.entity.AccountType;
import br.com.analistarural.domain.entity.SystemAccount;
import br.com.analistarural.domain.entity.User;
import br.com.analistarural.domain.entity.UserAccount;
import br.com.analistarural.domain.entity.fields.Farm;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class RepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SystemAccountRepository systemAccountRepository;

	@Autowired
	private AccountTypeRepository accountTypeRepository;

	@Autowired
	private UserAccountRepository userAccountRepository;

	@Autowired
	private FarmRepository farmRepository;

	@Test
	public void connect() {
		assertThat(userRepository, notNullValue());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void repositoryFlowTest() {
		User user1 = userRepository.save(createSingleUser());
		User user2 = userRepository.save(createSingleUser());

		assertThat(userRepository.findById(user1.getId()).isPresent(), is(true));
		assertThat(userRepository.findById(user2.getId()).isPresent(), is(true));
	}

	@Test
	@Transactional
	@Rollback(true)
	public void findAllUsersTest() {
		Iterable<User> users = userRepository.findAll();

		assertThat(users.toString()!="", is(true));
	}

	@Test
	@Transactional
	@Rollback(false)
	public void saveSystemAccountTest() {

		SystemAccount sa = systemAccountRepository.save(createSystemAccount());

		assertThat(systemAccountRepository.findById(sa.getId()).isPresent(),
				is(true));
	}

	@Test
	@Transactional
	@Rollback(false)
	public void saveUserAccountTest() {

		UserAccount ua = userAccountRepository.save(createUserAccount());

		assertThat(userAccountRepository.findById(ua.getId()).isPresent(),
				is(true));
	}

	@Test
	@Transactional
	@Rollback(false)
	public void saveFarmTest() {
		Farm farm = farmRepository.save(createFarm());

		assertThat(farmRepository.findById(farm.getId()).isPresent(), is(true));
	}

	private User createSingleUser() {
		User user = new User();
		user.setEmail("renatomoitinho@gmail.com");
		user.setLogin("renato");
		user.setName("Renato Dias");
		user.setPassword("123456");
		return user;
	}

	private SystemAccount createSystemAccount() {
		Optional<AccountType> at = accountTypeRepository
				.findByName("Produtor Rural");
		SystemAccount sa = new SystemAccount();
		sa.setAccountType(at.get());
		return sa;
	}

	private UserAccount createUserAccount() {
		Optional<SystemAccount> sa = systemAccountRepository.findById((long) 1);
		List<SystemAccount> systemAccounts = new ArrayList<SystemAccount>();
		systemAccounts.add(sa.get());

		UserAccount user = new UserAccount();
		user.setEmail("jocemarfg@gmail.com");
		user.setPassword("12345678");
		user.setSystemAccounts(systemAccounts);
		return user;
	}

	private Farm createFarm() {
		Optional<SystemAccount> sa = systemAccountRepository.findById((long) 1);

		Farm farm = new Farm();
		farm.setName("Fazenda Jataí");
		farm.setSystemAccount(sa.get());
		return farm;
	}

}
