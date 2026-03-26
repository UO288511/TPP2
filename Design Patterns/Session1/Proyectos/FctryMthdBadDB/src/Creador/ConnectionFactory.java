package Creador;

import Producto.DBConnection;

public interface ConnectionFactory {
	DBConnection createConnection();

}
