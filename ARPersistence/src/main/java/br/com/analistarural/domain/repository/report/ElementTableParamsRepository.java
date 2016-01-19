package br.com.analistarural.domain.repository.report;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.analistarural.domain.entity.report.ElementTableParams;

@Repository
public interface ElementTableParamsRepository extends CrudRepository<ElementTableParams, Long> {

	@Query("select s from ElementTableParams s")
	Stream<ElementTableParams> streamAllElements();

	// CRUD method using Optional
	Optional<ElementTableParams> findById(Long id);

	@Query("select s from ElementTableParams s where s.registration <= :registration")
	Iterable<ElementTableParams> findByRegistration(@Param("registration") Date registration);

}
