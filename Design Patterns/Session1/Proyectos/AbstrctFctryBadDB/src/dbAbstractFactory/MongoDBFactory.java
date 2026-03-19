package dbAbstractFactory;

import dbAbstractProduct.DBConnection;
import dbAbstractProduct.DBQuery;
import dbConcreteProductsConnection.MongoDBConnection;
import dbConcreteProductsQuery.MongoDBQuery;

public class MongoDBFactory implements DBFactory {

    public MongoDBFactory() {
        System.out.println("MongoDBFactory instantiated");
    }

    @Override
    public DBConnection createConnection() {
        return new MongoDBConnection();
    }

    @Override
    public DBQuery createQuery() {
        return new MongoDBQuery();
    }
}