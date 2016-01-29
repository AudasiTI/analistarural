package br.com.analistarural.domain.repository.product;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.analistarural.domain.entity.product.ProducedSeed;


@Repository
public interface ProducedSeedRepository extends CrudRepository<ProducedSeed, Long>{
	
	@Query("select ps from ProducedSeed ps")
	Stream<ProducedSeed> streamAllProducedSeeds();
	
	Optional<ProducedSeed> findByIdProducedSeed(Long idProducedSeed);

}
