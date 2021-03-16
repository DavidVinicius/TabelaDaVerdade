package connectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.IConnector;

public class SqliteConnector implements IConnector {
	private EntityManagerFactory entityManagerFactory;
	
	public SqliteConnector () {
		entityManagerFactory = Persistence.createEntityManagerFactory("TabelaVerdadeWebSqlite");		
	}
	
	@Override
	public EntityManager open() {		
		return entityManagerFactory.createEntityManager();
	}

	@Override
	public void close() {
		entityManagerFactory.close();		
	}

}
