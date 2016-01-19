package internetshop.niva.il.database;

import internetshop.niva.il.domain.User;
import internetshop.niva.il.database.DBException;

import java.util.List;

/**
 * Created by vitanovo on 07.12.2015.
 */
public interface UserDAO {

    void create(User user) throws internetshop.niva.il.database.DBException;

    void delete(User user) throws internetshop.niva.il.database.DBException;

    void update(User user) throws internetshop.niva.il.database.DBException;

    User getById(Long id) throws internetshop.niva.il.database.DBException;

    List<User> getAll() throws internetshop.niva.il.database.DBException;

    User getUserLogin(String login);


    /**
     * Check by login and email
     * @param login
     * @return user entity
     * @throws lv.javaguru.java2.database.DBException
     */
    User getUserByLogin(String login) throws internetshop.niva.il.database.DBException;

    boolean alreadyExists(String login);

}