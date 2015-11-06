package br.com.analistarural.domain.repository;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.analistarural.domain.entity.activity.ActivityFertilizer;

@Repository
public interface ActivityFertilizerRepository extends
		CrudRepository<ActivityFertilizer, Long> {

	@Query("select af from ActivityFertilizer af  join af.activity a where a.id = :activity_id")
	Stream<ActivityFertilizer> streamAllActivitiesFertilizerByActivity(
			@Param("activity_id") Long activity_id);

	// CRUD method using Optional
	Optional<ActivityFertilizer> findById(Long id);

}
