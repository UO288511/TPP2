package CeadorConcreto;

import Creador.ConnectionFactory;
import Producto.DBConnection;
import ProductoConcreto.MySQLConnection;

public class MySQLConnFactory implements ConnectionFactory{ 
	public DBConnection createConnection() {
        return new MySQLConnection();
    }
}
