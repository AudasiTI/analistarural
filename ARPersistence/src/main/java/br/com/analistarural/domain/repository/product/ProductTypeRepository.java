package br.com.analistarural.domain.repository.product;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.analistarural.domain.entity.product.ProductType;

public interface ProductTypeRepository extends CrudRepository<ProductType, Long>{
	@Query("select pt from ProductType pt")
	Stream<ProductType> streamAllProductType();

	// CRUD method using Optional
	Optional<ProductType> findById(Long id);

	// Query method using Optional

	Optional<ProductType> findByDescription(String decription);

}
