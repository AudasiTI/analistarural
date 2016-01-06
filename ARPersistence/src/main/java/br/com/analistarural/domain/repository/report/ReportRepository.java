package br.com.analistarural.domain.repository.report;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.analistarural.domain.entity.report.Report;

@Repository
public interface ReportRepository extends CrudRepository<Report, Long> {

	@Query("select r from Report r")
	Stream<Report> streamAllReports();

	// CRUD method using Optional
	Optional<Report> findById(Long id);

	// CRUD method using Optional
	@Query("select r from Report r where r.email=:email")
	Iterable<Report> findByEmail(@Param("email") String email);

}
