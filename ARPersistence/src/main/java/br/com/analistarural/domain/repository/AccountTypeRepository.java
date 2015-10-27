package br.com.analistarural.domain.repository;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.analistarural.domain.entity.Account.TypeUserAccount;

@Repository
public interface AccountTypeRepository extends
		CrudRepository<TypeUserAccount, Long> {

	@Query("select at from AccountType at")
	Stream<TypeUserAccount> streamAllAccountType();

	// CRUD method using Optional
	Optional<TypeUserAccount> findById(Long id);
	
	// CRUD method using Optional
	Optional<TypeUserAccount> findByName(String name);

}
