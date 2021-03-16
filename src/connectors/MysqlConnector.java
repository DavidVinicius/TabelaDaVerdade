package connectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.IConnector;

public class MysqlConnector implements IConnector {
	EntityManagerFactory entityManagerFactory;
	
	public MysqlConnector () {
		entityManagerFactory = Persistence.createEntityManagerFactory("TabelaVerdadeWeb");		
	}
	
	public EntityManager open()
	{		
		return entityManagerFactory.createEntityManager();
	}
	
	public void close()
	{
		this.entityManagerFactory.close();
	}
}
