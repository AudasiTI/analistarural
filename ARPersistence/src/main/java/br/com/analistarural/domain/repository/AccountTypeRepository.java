package br.com.analistarural.domain.repository;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.analistarural.domain.entity.AccountType;

@Repository
public interface AccountTypeRepository extends
		CrudRepository<AccountType, Long> {

	@Query("select at from AccountType at")
	Stream<AccountType> streamAllAccountType();

	// CRUD method using Optional
	Optional<AccountType> findById(Long id);
	
	// CRUD method using Optional
	Optional<AccountType> findByName(String name);

}
