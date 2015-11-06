package br.com.analistarural.domain.repository;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.analistarural.domain.entity.activity.Activity;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Long> {

	@Query("select a from Activity a  join a.field f where f.id = :field_id")
	Stream<Activity> streamAllActivitiesByField(@Param("field_id") Long field_id);

	// CRUD method using Optional
	Optional<Activity> findById(Long id);
}
