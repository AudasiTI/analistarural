package br.com.analistarural.domain.repository.product;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.analistarural.domain.entity.product.FuelType;

@Repository
public interface FuelTypeRepository extends CrudRepository<FuelType, Long>{

	@Query("select ft from FuelType ft")
	Stream<FuelType> streamAllFuelType();
	
	Optional<FuelType> findByIdFuelType(Long idFuelType);
	
	Optional<FuelType> findByName(String name);
	
}
