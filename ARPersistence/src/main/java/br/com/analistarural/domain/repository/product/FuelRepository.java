package br.com.analistarural.domain.repository.product;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.analistarural.domain.entity.product.Fuel;


@Repository
public interface FuelRepository extends CrudRepository<Fuel, Long>{

	@Query("select f from Fuel f")
	Stream<Fuel> streamAllFuel();
	
	Optional<Fuel> findByIdFuel(Long idFuel);
	
	//Optional<Fuel> findByName(String name);
}
