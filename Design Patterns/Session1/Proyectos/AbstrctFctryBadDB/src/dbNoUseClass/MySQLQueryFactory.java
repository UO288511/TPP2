package dbNoUseClass;

import dbAbstractProduct.DBQuery;
import dbConcreteProductsQuery.MySQLQuery;

public class MySQLQueryFactory implements QueryFactory {

    public MySQLQueryFactory() {
        System.out.println("MySQLQueryFactory instantiated");
    }

    @Override
    public DBQuery createQuery() {
        return new MySQLQuery();
    }
}
