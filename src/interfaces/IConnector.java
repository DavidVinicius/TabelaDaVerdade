package interfaces;

import javax.persistence.EntityManager;

public interface IConnector {
	public EntityManager open();
	public void close();
}
