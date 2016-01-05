package br.com.analistarural.domain.repository.product;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.analistarural.domain.entity.product.TypeVehicle;

@Repository
public interface TypeVehicleRepository extends CrudRepository<TypeVehicle, Long> {


	@Query("select tv from TypeVehicle tv")
	Stream<TypeVehicle> streamAllTypeVehicle();
	
	// CRUD method using Optional
	Optional<TypeVehicle> findByIdTypeVehicle(Long idTypeVehicle);

		// Query method using Optional
	Optional<TypeVehicle> findByName(String name);
}
