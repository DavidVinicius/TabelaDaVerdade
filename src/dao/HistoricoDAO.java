package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import connectors.MysqlConnector;
import model.Historico;

public class HistoricoDAO {	
	
	public HistoricoDAO() {
			
	}
	
	public void saveExpression(String expression) {		
		MysqlConnector conn = new MysqlConnector();
		EntityManager ent = conn.open();
		
		Historico hist = new Historico();
		hist.setExpression(expression);
		
		ent.getTransaction().begin();
		ent.persist(hist);		
		ent.getTransaction().commit();
				
		ent.close();
		conn.close();
	}
	
	public List<Historico> getAll(){			
		MysqlConnector conn = new MysqlConnector();
		EntityManager entityManager = conn.open(); 
							
		List<Historico> results = (List<Historico>) entityManager.createNativeQuery("select * from historico;", Historico.class).getResultList();							    	
				
		entityManager.close();
		conn.close();
		
		return results;
	}
}
