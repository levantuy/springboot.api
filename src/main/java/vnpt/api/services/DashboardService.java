package vnpt.api.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vnpt.api.model.Dashboard;

@Service
public class DashboardService {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public List<Dashboard> getAll(long userId) {
		List<Dashboard> dashboads;
		try {
			TypedQuery<Dashboard> q = entityManager.createQuery(
					"SELECT u FROM " + Dashboard.class.getName()
							+ " u LEFT JOIN UserDashboard ud ON u.name=ud.i AND ud.userId=:id where ud.id IS NULL",
					Dashboard.class).setParameter("id", userId);
			dashboads = q.getResultList();
		} finally {
		}
		return dashboads;
	}
}
