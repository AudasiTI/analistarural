package br.com.analistarural.domain.repository.product;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.analistarural.domain.entity.product.Assets;

@Repository
public interface AssetsRepository extends CrudRepository<Assets, Long>{

	@Query("select a from Assets a")
	Stream<Assets> streamAllAssets();
	
	// CRUD method using Optional
	Optional<Assets> findByIdAssets(Long idAssets);

		// Query method using Optional
	Optional<Assets> findByPatrimony(String patrimony);
}
