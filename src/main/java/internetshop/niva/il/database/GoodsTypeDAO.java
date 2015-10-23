package internetshop.niva.il.database;

import internetshop.niva.il.domain.GoodsType;

import java.util.List;

/**
 * Created by ilugovecs on 2015.10.23..
 */
public interface GoodsTypeDAO {

    void create(GoodsType goodstype) throws DBException;

    GoodsType getById(Long id) throws  DBException;

    void delete(Long id) throws DBException;

    void update(GoodsType goodstype) throws  DBException;

    List<GoodsType> getAll() throws DBException;

    int recordscount() throws DBException;

}
