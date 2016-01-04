package br.com.analistarural.domain.repository.product;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.analistarural.domain.entity.product.Consumption;

@Repository
public interface ConsumptionRepository extends CrudRepository<Consumption, Long> {

	@Query("select c from Consumption c")
	Stream<Consumption> streamAllConsumptions();
	
	// CRUD method using Optional
	Optional<Consumption> findByIdConsumption(Long idConsumption);

		// Query method using Optional
	//Optional<Feedstock> findByBrand(String brand);
}
