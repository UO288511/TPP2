package Client;

import CeadorConcreto.CassandraConnFactory;
import CeadorConcreto.MongoDBConnFactory;
import CeadorConcreto.MySQLConnFactory;
import Creador.ConnectionFactory;
import Producto.DBConnection;

public class Application_FactoryMethod {
	public static void main(String[] args) {

        System.out.println("=== Using MySQL (with Factory Method) ===");
        executeFactory(new MySQLConnFactory());

        System.out.println();

        System.out.println("=== Using MongoDB (with Factory Method) ===");
        executeFactory(new MongoDBConnFactory());
        
        System.out.println();

        System.out.println("=== Using Cassandra (with Factory Method) ===");
        executeFactory(new CassandraConnFactory());

    }
	
	private static void executeFactory(ConnectionFactory factory) {
        DBConnection connection = factory.createConnection();
        connection.open();
        connection.close();
	}
	
	

}
