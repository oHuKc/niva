package internetshop.niva.il.database;

import internetshop.niva.il.domain.TV;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
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

    List<TV> get4KUHD(int id) throws DBException;

    TV getByScreenSize(String id) throws DBException;

    byte[] getImage(int id) throws  DBException;

    byte[] toByteArrayImpl(Blob fromImageBlob, ByteArrayOutputStream baos) throws  DBException, SQLException, IOException;

    byte[] toByteArray(Blob fromImageBlob);
}
