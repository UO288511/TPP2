package dbFactory_creadorConcreto;

import db.ConnectionFactory;
import db.DBConnection;
import dbConnection_productoConcreto.MySQLConnection;

public class MySQLConnFactory implements ConnectionFactory{ 
	public DBConnection createConnection() {
        return new MySQLConnection();
    }
}
