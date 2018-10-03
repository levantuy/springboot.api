package vnpt.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vnpt.api.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

}
