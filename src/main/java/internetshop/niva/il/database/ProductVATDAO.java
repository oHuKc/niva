package internetshop.niva.il.database;

import internetshop.niva.il.domain.ProductVAT;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Igor on 2015.12.21..
 */
public interface ProductVATDAO {

    void create(ProductVAT productVAT) throws DBException, SQLException;

    ProductVAT getById(String id) throws DBException, SQLException;

    void delete(String id) throws DBException;

    List<ProductVAT> getAll() throws DBException;

}
