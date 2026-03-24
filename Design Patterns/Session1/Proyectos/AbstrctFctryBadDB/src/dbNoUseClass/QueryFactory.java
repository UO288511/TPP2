package dbNoUseClass;

import dbAbstractProduct.DBQuery;

public interface QueryFactory {
    DBQuery createQuery();
}
