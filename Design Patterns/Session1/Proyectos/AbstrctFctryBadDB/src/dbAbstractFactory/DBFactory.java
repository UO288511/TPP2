package dbAbstractFactory;

import dbAbstractProduct.DBConnection;
import dbAbstractProduct.DBQuery;

public interface DBFactory {
	DBConnection createConnection();
	DBQuery createQuery();
}
