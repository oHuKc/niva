package internetshop.niva.il.database;

import internetshop.niva.il.domain.ProductVAT;

import java.sql.SQLException;

/**
 * Created by Igor on 2015.12.21..
 */
public interface ProductVATDAO {

    void create(ProductVAT productVAT) throws DBException, SQLException;

    ProductVAT getById(String id) throws DBException, SQLException;
}
