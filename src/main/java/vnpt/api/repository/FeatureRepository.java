package vnpt.api.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import vnpt.api.model.Feature;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {
	Optional<Feature> findById(Long featureId);
}
