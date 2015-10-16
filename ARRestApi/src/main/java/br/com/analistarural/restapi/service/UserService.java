package br.com.analistarural.restapi.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.analistarural.domain.entity.User;
import br.com.analistarural.domain.repository.UserRepository;

@Service
@Transactional
@Cacheable(value = "UserServiceCache")
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User findByLogin(String login) {
        Optional<User> optional = userRepository.findByLogin(login);
        return optional.orElseThrow(() -> new UsernameNotFoundException(String.format("User %s does not exist!", login)));
    }

	public Iterable<User> findAll() {
		return userRepository.findAll();
	}
}
