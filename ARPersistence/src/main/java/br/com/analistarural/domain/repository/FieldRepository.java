package br.com.analistarural.domain.repository;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.analistarural.domain.entity.field.Field;

@Repository
public interface FieldRepository extends CrudRepository<Field, Long> {

	@Query("select f from Field f join f.farm fa where fa.id = :farm_id")
	Iterable<Field> findFieldsByFarm(@Param("farm_id") Long farm_id);

	// CRUD method using Optional
	Optional<Field> findById(Long id);

	// Query method using Optional
	@Query("select f from Field f  join f.farm fa where fa.id = :farm_id and f.name = :name")
	Optional<Field> findByName(@Param("name") String name, @Param("farm_id") Long farm_id);

	@Query("select f from Field f join f.farm fa join fa.systemAccount sa where sa.id = :system_account_id")
	Iterable<Field> findFieldsBySystemAccount(@Param("system_account_id") Long systemAccountID);
}
