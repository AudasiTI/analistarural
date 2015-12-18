package br.com.analistarural.domain.repository.product;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.analistarural.domain.entity.product.Seed;

@Repository
public interface SeedRepository extends CrudRepository<Seed, Long> {

	@Query("select s from Seed s")
	Stream<Seed> streamAllSeeds();
	
	//Optional<Seed> findById(Long id);
	
	//Optional<Seed> findByName(String name);
}
