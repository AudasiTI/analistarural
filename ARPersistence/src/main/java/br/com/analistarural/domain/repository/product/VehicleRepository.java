package br.com.analistarural.domain.repository.product;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.analistarural.domain.entity.product.Vehicle;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long>{


	@Query("select v from Vehicle v")
	Stream<Vehicle> streamAllVehicle();
	
	// CRUD method using Optional
	Optional<Vehicle> findByIdVehicle(Long idVehicle);

		// Query method using Optional
	Optional<Vehicle> findByModel(String model);
}
