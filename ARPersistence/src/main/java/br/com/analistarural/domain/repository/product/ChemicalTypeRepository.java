package br.com.analistarural.domain.repository.product;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.analistarural.domain.entity.product.ChemicalType;


public interface ChemicalTypeRepository extends CrudRepository<ChemicalType, Long>{
	@Query("select ct from ChemicalType ct")
	Stream<ChemicalType> streamAllProductType();

	// CRUD method using Optional
	Optional<ChemicalType> findById(Long id);

	// Query method using Optional

	Optional<ChemicalType> findByName(String name);

}
