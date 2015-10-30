package br.com.analistarural.domain.repository.product;


import org.springframework.stereotype.Repository;


import br.com.analistarural.domain.entity.product.ProductCategory;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long>{
	
	@Query("select pc from ProductCategory pc")
	Stream<ProductCategory> streamAllProductCategory();

	// CRUD method using Optional
	Optional<ProductCategory> findById(Long id);

	// Query method using Optional

	Optional<ProductCategory> findByDescription(String decription);

}
