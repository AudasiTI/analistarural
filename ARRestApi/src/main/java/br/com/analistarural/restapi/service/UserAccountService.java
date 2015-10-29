package br.com.analistarural.restapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.analistarural.domain.entity.account.UserAccount;
import br.com.analistarural.domain.repository.UserAccountRepository;

@Service
@Transactional
@Cacheable(value = "UserAccountServiceCache")
public class UserAccountService {

	@Autowired
	private UserAccountRepository userAccountRepository;

	public UserAccount findByLogin(String login) {
		Optional<UserAccount> optional = userAccountRepository
				.findByEmail(login);
		return optional.orElseThrow(() -> new UsernameNotFoundException(String
				.format("User %s does not exist!", login)));
	}

	public Iterable<UserAccount> findAll() {
		return userAccountRepository.findAll();
	}
}
