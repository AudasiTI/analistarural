package br.com.analistarural.domain.repository.product;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.analistarural.domain.entity.product.Defensive;

@Repository
public interface DefensiveRepository extends CrudRepository<Defensive, Long> {

	@Query("select d from Defensive d")
	Stream<Defensive> streamAllDefensive();
	
	Optional<Defensive> findByIdDefensive(Long idDefensive);
	
	//Optional<Defensive> findByName(String name);
}
