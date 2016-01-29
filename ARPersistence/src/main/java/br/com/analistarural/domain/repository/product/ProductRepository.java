package br.com.analistarural.domain.repository.product;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.analistarural.domain.entity.product.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	
	@Query("select p from Product p")
	Stream<Product> streamAllProducts();

	// CRUD method using Optional
	Optional<Product> findByIdProduct(Long idProduct);

	// Query method using Optional
	Optional<Product> findByName(String name);
	
}
