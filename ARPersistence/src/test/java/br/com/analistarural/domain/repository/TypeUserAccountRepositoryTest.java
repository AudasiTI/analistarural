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
public class TypeUserAccountRepositoryTest {

	@Autowired
	private TypeUserAccountRepository typeUserAccountRepository;

	@Test
	public void connect() {
		assertThat(typeUserAccountRepository, notNullValue());
	}

	private TypeUserAccount createTypeUserAccountTest() {

		TypeUserAccount type = new TypeUserAccount();
		type.setName("Tipo de conta de testes");
		return type;
	}

	@Test
	@Transactional
	@Rollback(true)
	public void findAllTypeAccountsTest() {

		Iterable<TypeUserAccount> types = typeUserAccountRepository.findAll();
		assertThat(types.toString() != "", is(true));
	}

	@Test
	@Transactional
	@Rollback(true)
	public void saveTypeUserAccountTest() {

		TypeUserAccount tua = typeUserAccountRepository
				.save(createTypeUserAccountTest());
		assertThat(typeUserAccountRepository.findById(tua.getId()).isPresent(),
				is(true));

	}
}
