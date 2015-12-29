package br.com.analistarural.domain.repository.product;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.analistarural.domain.entity.product.Feedstock;
import br.com.analistarural.domain.entity.product.Product;

@Repository
public interface FeedstockRepository extends CrudRepository<Feedstock, Long>{

	@Query("select f from Feedstock f")
	Stream<Feedstock> streamAllFeedstocks();
	
	// CRUD method using Optional
	Optional<Feedstock> findByIdFeedstock(Long idFeedstock);

		// Query method using Optional
	Optional<Feedstock> findByBrand(String brand);
		
}
