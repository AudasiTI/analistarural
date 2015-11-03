package br.com.analistarural.domain.repository;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.analistarural.domain.entity.field.FieldGroup;

public interface FieldGroupRepository extends CrudRepository<FieldGroup, Long> {

	@Query("select fr from FieldRepository fr join Field f where f.farm.id = :farm_id")
	Stream<FieldGroup> streamAllFarmsBySystemAccount(
			@Param("farm_id") Long farm_id);

	// CRUD method using Optional
	Optional<FieldGroup> findById(Long id);

	// Query method using Optional
	@Query("select fr from FieldRepository fr join Field f where f.farm.id = :farm_id and fr.name = :name")
	Optional<FieldGroup> findByName(@Param("name") String name,
			@Param("farm_id") Long farm_id);

}
