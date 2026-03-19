package dbNoUseClass;

import dbAbstractProduct.DBConnection;
import dbConcreteProductsConnection.MongoDBConnection;

public class MongoDBConnectionFactory implements ConnectionFactory {

    public MongoDBConnectionFactory() {
        System.out.println("MongoDBConnectionFactory instantiated");
    }

    @Override
    public DBConnection createConnection() {
        return new MongoDBConnection();
    }
}
