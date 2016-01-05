package br.com.analistarural.domain.repository.product;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.analistarural.domain.entity.product.Parts;

@Repository
public interface PartsRepository extends CrudRepository<Parts, Long> {

	@Query("select p from Parts p")
	Stream<Parts> streamAllParts();
	
	Optional<Parts> findByIdParts(Long idParts);
	
	//Optional<Fuel> findByName(String name);
}
