package br.com.analistarural.domain.repository.report;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.analistarural.domain.entity.report.ElementDefaultValue;

@Repository
public interface ElementDefaultValueRepository extends CrudRepository<ElementDefaultValue, Long> {

	@Query("select s from ElementDefaultValue s")
	Stream<ElementDefaultValue> streamAllElements();

	// CRUD method using Optional
	Optional<ElementDefaultValue> findById(Long id);

	@Query("select s from ElementDefaultValue s join s.params p where p.id = :table_params_id")
	Iterable<ElementDefaultValue> findByTableParams(@Param("table_params_id") Long table_params_id);

}
