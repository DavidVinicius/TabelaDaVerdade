package connectors;

import javax.persistence.EntityManager;

import interfaces.IConnector;

public class ConnectorFactory {
	
	public static IConnector getConnector(String connector) {
		switch (connector) {
		case "MySQL":
			return new MysqlConnector();
		case "SQlite":
			return new SqliteConnector();
		default:
			return new SqliteConnector();
		}
	}
}
