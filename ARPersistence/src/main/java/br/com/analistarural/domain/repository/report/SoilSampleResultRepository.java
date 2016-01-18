package br.com.analistarural.domain.repository.report;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.analistarural.domain.entity.report.SoilSampleResult;

@Repository
public interface SoilSampleResultRepository extends CrudRepository<SoilSampleResult, Long> {

	@Query("select s from SoilSampleResult s")
	Stream<SoilSampleResult> streamAllElements();

	// CRUD method using Optional
	Optional<SoilSampleResult> findById(Long id);

	@Query("select s from SoilSampleResult s join s.report r where r.id = :report_id")
	Iterable<SoilSampleResult> findByReport(@Param("report_id") Long report_id);

}
