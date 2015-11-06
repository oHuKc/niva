package internetshop.niva.il.database;

import internetshop.niva.il.domain.TV;

import java.util.List;

/**
 * Created by ilugovecs on 2015.11.05..
 */
public interface TVDAO {

    void create(TV tv) throws DBException;

    TV getById(Long id) throws DBException;

    void delete(Long id) throws DBException;

    void update(TV tv) throws DBException;

    List<TV> getAll() throws DBException;

    int recordscount() throws DBException;

    List<TV> get4KUHD(int id) throws DBException;

    TV getByScreenSize(String id) throws DBException;
}
