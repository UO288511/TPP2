package db;

import dbFactory_creadorConcreto.CassandraConnFactory;
import dbFactory_creadorConcreto.MongoDBConnFactory;
import dbFactory_creadorConcreto.MySQLConnFactory;

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
