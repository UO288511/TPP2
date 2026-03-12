package dbFactory_creadorConcreto;

import db.ConnectionFactory;
import db.DBConnection;
import dbConnection_productoConcreto.MongoDBConnection;

public class MongoDBConnFactory implements ConnectionFactory{
	public DBConnection createConnection() {
        return new MongoDBConnection();
    }
}
