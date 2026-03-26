package CeadorConcreto;

import Creador.ConnectionFactory;
import Producto.DBConnection;
import ProductoConcreto.MongoDBConnection;

public class MongoDBConnFactory implements ConnectionFactory{
	public DBConnection createConnection() {
        return new MongoDBConnection();
    }
}
