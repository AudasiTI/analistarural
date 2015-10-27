package br.com.analistarural.domain.repository;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.analistarural.domain.entity.Account.SystemAccount;

@Repository
public interface SystemAccountRepository extends
		CrudRepository<SystemAccount, Long> {

	@Query("select sa from SystemAccount sa")
	Stream<SystemAccount> streamAllSystemAccount();

	// CRUD method using Optional
	Optional<SystemAccount> findById(Long id);
}
