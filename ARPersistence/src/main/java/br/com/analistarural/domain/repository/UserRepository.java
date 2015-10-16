package br.com.analistarural.domain.repository;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.analistarural.domain.entity.User;

@Repository
public interface UserRepository {

	@Query("select u from User u")
	Stream<User> streamAllUsers();

	// CRUD method using Optional
	Optional<User> findById(Long id);

	// Query method using Optional

	Optional<User> findByLogin(String name);
}
