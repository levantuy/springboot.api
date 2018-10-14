package vnpt.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vnpt.api.model.UserDashboard;

@Repository
public interface UserDashboardReposity extends JpaRepository<UserDashboard, Long> {
	List<UserDashboard> findByUserId(long userId);
}
