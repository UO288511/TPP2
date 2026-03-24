package db;

import dbAbstractFactory.DBFactory;
import dbAbstractFactory.MongoDBFactory;
import dbAbstractFactory.MySQLFactory;
import dbAbstractProduct.DBConnection;
import dbAbstractProduct.DBQuery;

public class Application_AbstractFactory {

    private final DBFactory factory;

    DBConnection connection;
    DBQuery query;

    public Application_AbstractFactory(DBFactory factory) {
        this.factory = factory;
    }

    public void createConnection() {
        connection = factory.createConnection();
    }

    public void createQuery() {
        query = factory.createQuery();
    }

    public static void main(String[] args) {

        System.out.println("=== CASE 1: MySQL family ===");
        Application_AbstractFactory app1 =
                new Application_AbstractFactory(new MySQLFactory());

        app1.createConnection();
        app1.connection.open();
        app1.connection.close();

        app1.createQuery();
        app1.query.execute();
        app1.query.print();

        System.out.println();

        System.out.println("=== CASE 2: MongoDB family ===");
        Application_AbstractFactory app2 =
                new Application_AbstractFactory(new MongoDBFactory());

        app2.createConnection();
        app2.connection.open();
        app2.connection.close();

        app2.createQuery();
        app2.query.execute();
        app2.query.print();
    }
}