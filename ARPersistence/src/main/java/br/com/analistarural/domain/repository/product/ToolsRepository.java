package br.com.analistarural.domain.repository.product;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.analistarural.domain.entity.product.Tools;

@Repository
public interface ToolsRepository extends CrudRepository<Tools, Long>{
	
	@Query("select t from Tools t")
	Stream<Tools> streamAllTools();
	
	// CRUD method using Optional
	Optional<Tools> findByIdTools(Long idTools);

}
