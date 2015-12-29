package br.com.analistarural.domain.repository.product;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.analistarural.domain.entity.product.ProductFinished;

@Repository
public interface ProductFinishedRepository extends CrudRepository<ProductFinished, Long>{
		
		@Query("select pf from ProductFinished pf")
		Stream<ProductFinished> streamAllProductsFinished();

		// CRUD method using Optional
		Optional<ProductFinished> findByIdProductFinished(Long idProductFinished);

		// Query method using Optional
		//Optional<Product> findByName(String name);
	
	
}
