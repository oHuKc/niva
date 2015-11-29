package internetshop.niva.il.database;

import internetshop.niva.il.domain.Customer;

import java.util.List;

/**
 * Created by Igor on 2015.10.19..
 */
public interface CustomerDAO {
    void create(Customer user) throws DBException;

    Customer getById(long id) throws DBException;

    void delete(Long id) throws DBException;

    void update(Customer user) throws DBException;

    List<Customer> getAll() throws DBException;

}
