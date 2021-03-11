package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Exemplo {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TabelaVerdadeWeb");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Historico historico = entityManager.find(Historico.class, 1);
		System.out.println(historico.getExpression());
		
		entityManager.close();
		entityManagerFactory.close();
	}
}
