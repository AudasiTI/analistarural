package br.com.analistarural.domain.repository.report;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.analistarural.domain.entity.report.ElementType;

@Repository
public interface ElementTypeRepository extends CrudRepository<ElementType, Long> {

	@Query("select e from ElementType e")
	Stream<ElementType> streamAllElements();

	// CRUD method using Optional
	Optional<ElementType> findById(Long id);

	// CRUD method using Optional
	Optional<ElementType> findByDescription(String description);
}
