package br.com.analistarural.domain.repository.report;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.analistarural.domain.entity.report.ElementValue;

@Repository
public interface ElementValueRepository extends CrudRepository<ElementValue, Long> {

	@Query("select e from ElementValue e")
	Stream<ElementValue> streamAllElements();

	// CRUD method using Optional
	Optional<ElementValue> findById(Long id);

	@Query("select e from ElementValue e join e.report r where r.id = :report_id")
	Iterable<ElementValue> findByReport(@Param("report_id") Long report_id);

}
