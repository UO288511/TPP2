package dbAbstractFactory;

import dbAbstractProduct.DBConnection;
import dbAbstractProduct.DBQuery;
import dbConcreteProductsConnection.MySQLConnection;
import dbConcreteProductsQuery.MySQLQuery;

public class MySQLFactory implements DBFactory {

    public MySQLFactory() {
        System.out.println("MySQLFactory instantiated");
    }

    @Override
    public DBConnection createConnection() {
        return new MySQLConnection();
    }

    @Override
    public DBQuery createQuery() {
        return new MySQLQuery();
    }
}