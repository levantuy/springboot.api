package vnpt.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vnpt.api.model.Dashboard;

@Repository
public interface DashboardRepository extends JpaRepository<Dashboard, Long> {
	List<Dashboard> findAll();
}
