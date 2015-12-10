package br.com.analistarural.domain.repository.product;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.analistarural.domain.entity.product.Chemical;

@Repository
public interface ChemicalRepository extends CrudRepository<Chemical, Long> {

	@Query("select c from Chemical c")
	Stream<Chemical> streamAllChemicals();
	
	Optional<Chemical> findById(Long id);
	
	Optional<Chemical> findByName(String name);
}
