package br.com.analistarural.domain.repository;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.analistarural.domain.entity.activity.ActivityType;

@Repository
public interface ActivityTypeRepository extends
		CrudRepository<ActivityType, Long> {

	@Query("select at from ActivityType at")
	Stream<ActivityType> streamAll();

	// CRUD method using Optional
	Optional<ActivityType> findById(Long id);

	// CRUD method using Optional
	Optional<ActivityType> findByName(String name);

}
