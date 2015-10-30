package br.com.analistarural.domain.repository.product;


import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.analistarural.domain.entity.product.Fertilizer;

@Repository
public interface FertilizerRepository extends CrudRepository<Fertilizer, Long> {

	@Query("select f from Fertilizer f")
	Stream<Fertilizer> streamAllFertilizers();
	
	Optional<Fertilizer> findById(Long id);
	
	Optional<Fertilizer> findByName(String name);
}
