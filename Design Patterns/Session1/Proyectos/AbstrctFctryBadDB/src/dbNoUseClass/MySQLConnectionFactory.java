package dbNoUseClass;

import dbAbstractProduct.DBConnection;
import dbConcreteProductsConnection.MySQLConnection;

public class MySQLConnectionFactory implements ConnectionFactory {

    public MySQLConnectionFactory() {
        System.out.println("MySQLConnectionFactory instantiated");
    }

    @Override
    public DBConnection createConnection() {
        return new MySQLConnection();
    }
}
