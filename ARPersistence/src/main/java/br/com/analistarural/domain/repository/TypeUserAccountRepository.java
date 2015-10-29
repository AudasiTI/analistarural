package br.com.analistarural.domain.repository;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.analistarural.domain.entity.account.TypeUserAccount;

@Repository
public interface TypeUserAccountRepository extends
		CrudRepository<TypeUserAccount, Long> {

	@Query("select tua from TypeUserAccount tua")
	Stream<TypeUserAccount> streamAll();

	// CRUD method using Optional
	Optional<TypeUserAccount> findById(Long id);

	// CRUD method using Optional
	Optional<TypeUserAccount> findByName(String name);
}
