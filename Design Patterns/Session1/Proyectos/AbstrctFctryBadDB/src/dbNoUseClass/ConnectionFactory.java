package dbNoUseClass;

import dbAbstractProduct.DBConnection;

public interface ConnectionFactory {
    DBConnection createConnection();
}
