package br.com.analistarural.domain.repository.product;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.analistarural.domain.entity.product.Measurement;

@Repository
public interface MeasurementRepository extends CrudRepository<Measurement, Long>{
	
	@Query("select m from Measurement m")
	Stream<Measurement> streamAllMeasurement();
	
	// CRUD method using Optional
		Optional<Measurement> findByIdMeasurement(Long idMeasurement);

		// Query method using Optional

		Optional<Measurement> findByName(String name);

}
