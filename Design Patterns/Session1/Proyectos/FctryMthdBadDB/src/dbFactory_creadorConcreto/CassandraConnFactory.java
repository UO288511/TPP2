package dbFactory_creadorConcreto;

import db.ConnectionFactory;
import db.DBConnection;
import dbConnection_productoConcreto.CassandraConnection;

public class CassandraConnFactory implements ConnectionFactory {

	@Override
	public DBConnection createConnection() {
		return new CassandraConnection();
	}

}
