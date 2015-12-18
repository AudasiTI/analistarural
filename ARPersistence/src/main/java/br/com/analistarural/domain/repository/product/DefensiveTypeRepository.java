package br.com.analistarural.domain.repository.product;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.analistarural.domain.entity.product.DefensiveType;


public interface DefensiveTypeRepository extends CrudRepository<DefensiveType, Long>{
	@Query("select dt from DefensiveType dt")
	Stream<DefensiveType> streamAllDefensiveType();

	// CRUD method using Optional
	Optional<DefensiveType> findByIdDefensiveType(Long idDefensiveType);

	// Query method using Optional

	Optional<DefensiveType> findByName(String name);

}
