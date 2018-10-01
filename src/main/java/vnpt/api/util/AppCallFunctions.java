package vnpt.api.util;

import java.math.BigDecimal;

import javax.persistence.*;

public class AppCallFunctions {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
	private static EntityManager em = emf.createEntityManager();
	
	public static long getNextId(String tableName) {		
		BigDecimal id;
		id = (BigDecimal) em.createNativeQuery("select get_keys('" + tableName + "') from dual").getSingleResult();
		em.close();
		emf.close();
		return id.longValueExact();
	}
}
