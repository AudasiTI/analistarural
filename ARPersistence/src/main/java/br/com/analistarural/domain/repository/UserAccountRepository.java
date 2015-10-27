package br.com.analistarural.domain.repository;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.analistarural.domain.entity.Account.UserAccount;

public interface UserAccountRepository extends
		CrudRepository<UserAccount, Long> {

	@Query("select ua from UserAccount ua")
	Stream<UserAccount> streamAllUsers();

	// CRUD method using Optional
	Optional<UserAccount> findById(Long id);

	// Query method using Optional

	Optional<UserAccount> findByEmail(String email);

}
