package br.com.analistarural.domain.repository.product;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import br.com.analistarural.domain.entity.product.Source;

public interface SourceRepository extends CrudRepository<Source, Long>{

	@Query("select s from Source s")
	Stream<Source> streamAllSource();

	// CRUD method using Optional
	Optional<Source> findById(Long id);

	// Query method using Optional

	Optional<Source> findByName(String name);
}
