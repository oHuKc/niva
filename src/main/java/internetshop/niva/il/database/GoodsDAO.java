package internetshop.niva.il.database;

import internetshop.niva.il.domain.Goods;

import java.util.List;

/**
 * Created by ilugovecs on 2015.10.21..
 */
public interface GoodsDAO {

    void create(Goods goods) throws DBException ;

    Goods getById(Long id) throws DBException;

    void delete(Long id) throws DBException;

    void update(Goods goods) throws DBException;

    List<Goods> getAll() throws DBException;

    int recordscount() throws DBException;

}
