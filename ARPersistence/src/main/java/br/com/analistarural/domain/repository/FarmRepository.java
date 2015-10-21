package br.com.analistarural.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.analistarural.domain.entity.fields.Farm;

@Repository
public interface FarmRepository extends CrudRepository<Farm, Long> {

	@Query("select f from Farm f  join f.systemAccount sa where sa.id = :system_account_id")
	Optional<Farm> streamAllFarmsBySystemAccount(
			@Param("system_account_id") Long system_account_id);

	// CRUD method using Optional
	Optional<Farm> findById(Long id);

	// Query method using Optional
	@Query("select f from Farm f join f.systemAccount as sa where sa.id = :system_account_id and f.name = :name")
	Optional<Farm> findByName(@Param("name") String name,
			@Param("system_account_id") Long system_account_id);

}
