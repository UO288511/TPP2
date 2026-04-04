package ProductoConcreto;

import Producto.DBConnection;

public class CassandraConnection implements DBConnection{

    public CassandraConnection() {
        System.out.println("Cassandra object created");
    }

	@Override
	public boolean open() {
		System.out.println("Cassandra connection ==> open");
		return false;
	}

	@Override
	public boolean close() {
		System.out.println("Cassandra connection ==> open");
		return false;
	}

}
