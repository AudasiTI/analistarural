package br.com.analistarural.domain.repository.product;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import br.com.analistarural.domain.entity.product.Variety;

public interface VarietyRepository extends CrudRepository<Variety, Long> {

	@Query("select v from Variety v")
	Stream<Variety> streamAllVariety();

	// CRUD method using Optional
	Optional<Variety> findByIdVariety(Long idVariety);

	// Query method using Optional

	Optional<Variety> findByName(String name);
}
