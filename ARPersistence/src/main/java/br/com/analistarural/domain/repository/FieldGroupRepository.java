package br.com.analistarural.domain.repository;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.analistarural.domain.entity.field.FieldGroup;

@Repository
public interface FieldGroupRepository extends CrudRepository<FieldGroup, Long> {

	@Query("select fr from FieldGroup fr join fr.farm f where f.id = :farm_id")
	Stream<FieldGroup> streamAllFarmsBySystemAccount(
			@Param("farm_id") Long farm_id);

	// CRUD method using Optional
	Optional<FieldGroup> findById(Long id);

	// Query method using Optional
	@Query("select fr from FieldGroup fr join fr.farm f where f.id = :farm_id and fr.name = :name")
	Optional<FieldGroup> findByName(@Param("name") String name,
			@Param("farm_id") Long farm_id);

}
