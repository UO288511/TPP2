package CeadorConcreto;

import Creador.ConnectionFactory;
import Producto.DBConnection;
import ProductoConcreto.CassandraConnection;

public class CassandraConnFactory implements ConnectionFactory {

	@Override
	public DBConnection createConnection() {
		return new CassandraConnection();
	}

}
