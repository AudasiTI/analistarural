package br.com.analistarural.domain.repository.product;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.analistarural.domain.entity.product.ChemicalElement;

@Repository
public interface ChemicalElementRepository extends CrudRepository<ChemicalElement, Long>{
	
	@Query("select ce from ChemicalElement ce")
	Stream<ChemicalElement> streamAllChemicalElement();

	// CRUD method using Optional
	Optional<ChemicalElement> findByIdChemicalElement(Long idChemicalElement);

	// Query method using Optional

	Optional<ChemicalElement> findByName(String name);
}
