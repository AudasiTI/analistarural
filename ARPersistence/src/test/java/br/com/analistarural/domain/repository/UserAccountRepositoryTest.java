package br.com.analistarural.domain.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
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
import br.com.analistarural.domain.entity.account.TypeUserAccount;
import br.com.analistarural.domain.entity.account.UserAccount;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public class UserAccountRepositoryTest {

	@Autowired
	private UserAccountRepository userAccountRepository;

	@Autowired
	private SystemAccountRepository systemAccountRepository;

	@Autowired
	private TypeUserAccountRepository typeUserAccountRepository;

	@Test
	public void connect() {
		assertThat(userAccountRepository, notNullValue());
	}

	private UserAccount createUserAccountTest() {
		Optional<SystemAccount> sa = systemAccountRepository.findById((long) 1);
		Optional<TypeUserAccount> tua = typeUserAccountRepository
				.findByName("user");

		UserAccount user = new UserAccount();
		user.setEmail("jocemarfg@gmail.com");
		user.setPassword("12345678");
		user.setSystemAccount(sa.get());
		user.setTypeUserAccount(tua.get());
		return user;
	}

	private UserAccount createUserAccountWithoutTypeUserTest() {
		Optional<SystemAccount> sa = systemAccountRepository.findById((long) 1);

		UserAccount user = new UserAccount();
		user.setEmail("jocemarfg@gmail.com");
		user.setPassword("12345678");
		user.setSystemAccount(sa.get());
		return user;
	}

	private UserAccount createUserAccountWithoutSystemAccount() {
		Optional<TypeUserAccount> tua = typeUserAccountRepository
				.findByName("user");

		UserAccount user = new UserAccount();
		user.setEmail("jocemarfg@gmail.com");
		user.setPassword("12345678");
		user.setTypeUserAccount(tua.get());
		return user;
	}

	@Test
	@Transactional
	@Rollback(true)
	public void findAllUsersTest() {

		Iterable<UserAccount> users = userAccountRepository.findAll();
		assertThat(users.toString() != "", is(true));
	}

	@Test
	@Transactional
	@Rollback(true)
	public void saveUserAccountTest() {

		UserAccount ua = userAccountRepository.save(createUserAccountTest());
		assertThat(userAccountRepository.findById(ua.getId()).isPresent(),
				is(true));

	}

//	@Test
//	@Transactional
//	@Rollback(true)
//	public void saveUserAccountWithoutTypeUserTest() {
//
//		UserAccount ua = userAccountRepository
//				.save(createUserAccountWithoutTypeUserTest());
//		assertThat(userAccountRepository.findById(ua.getId()).isPresent(),
//				is(true));
//
//	}

//	@Test
//	@Transactional
//	@Rollback(true)
//	public void saveUserAccountWithoutSystemAccountTest() {
//
//		UserAccount ua = userAccountRepository
//				.save(createUserAccountWithoutSystemAccount());
//		assertThat(userAccountRepository.findById(ua.getId()).isPresent(),
//				is(false));
//
//	}

	@Test
	@Transactional
	@Rollback(true)
	public void loadUserAccountTest() {

		UserAccount ua = userAccountRepository.save(createUserAccountTest());
		Optional<UserAccount> user = userAccountRepository.findById(ua.getId());
		assertThat(user.get().getSystemAccount().getId() > 0, is(true));
		assertThat(user.get().getTypeUserAccount().getId() > 0, is(true));

	}

}
