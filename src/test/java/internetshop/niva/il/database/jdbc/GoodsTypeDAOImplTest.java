package internetshop.niva.il.database.jdbc;

import internetshop.niva.il.database.DBException;
import internetshop.niva.il.domain.GoodsType;
import junit.framework.TestCase;
import junit.framework.TestResult;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ilugovecs on 2015.10.23..
 */
public class GoodsTypeDAOImplTest extends TestCase {

    private DbCleaner databaseCleaner = new DbCleaner();
    private GoodsTypeDAOImpl goodsTypeDAO = new GoodsTypeDAOImpl();

    @Before
    public void init() throws DBException {
        try {
            databaseCleaner.cleanDatabase();
        } catch (DBException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testCreate () throws DBException, SQLException {

        GoodsType gdsType = createGoodsType("LG77","LG77TV","TV");

        goodsTypeDAO.create(gdsType);

        GoodsType goodsTypeFromDB = goodsTypeDAO.getById(gdsType.getItemId());
        assertNotNull(goodsTypeFromDB);
        assertEquals(gdsType.getItemId(), goodsTypeFromDB.getItemId());
        assertEquals(gdsType.getItemModel(), goodsTypeFromDB.getItemModel());
        assertEquals(gdsType.getItemDescripton(), goodsTypeFromDB.getItemDescripton());
        assertEquals(gdsType.getItemType(), goodsTypeFromDB.getItemType());

    }
    @Test
    public void testMultipleItemsAdd() throws DBException, SQLException {

        GoodsType goodstype1 = createGoodsType("Samsung ZX","Samsung ZX 4534 ","TV");
        GoodsType goodstype2 = createGoodsType("Asus","Asus Desktop x43534 ","Desktop");
        GoodsType goodstype3 = createGoodsType("Toshiba","xcbvxcbvcv","Desktop");
        GoodsType goodstype4 = createGoodsType("Nexus","Sdfgdgdfgdsf","MobilePhone");
        GoodsType goodstype5 = createGoodsType("HTC","sdfsagdfsgdfg","MobilePhone");
        GoodsType goodstype6 = createGoodsType("Athlon","werwerwer ","PC");
        GoodsType goodstype7 = createGoodsType("IntelCeleron","werwrwq","PC");
        GoodsType goodstype8 = createGoodsType("Dell","dfgdfgdfgdf","Desktop");
        GoodsType goodstype9 = createGoodsType("Athlon2323","45643643","PC");
        GoodsType goodstype10 = createGoodsType("IBM","S23423423","Desktop");
        goodsTypeDAO.create(goodstype1);
        goodsTypeDAO.create(goodstype2);
        goodsTypeDAO.create(goodstype3);
        goodsTypeDAO.create(goodstype4);
        goodsTypeDAO.create(goodstype5);
        goodsTypeDAO.create(goodstype6);
        goodsTypeDAO.create(goodstype7);
        goodsTypeDAO.create(goodstype8);
        goodsTypeDAO.create(goodstype9);
        goodsTypeDAO.create(goodstype10);

        List<GoodsType> goodstype = goodsTypeDAO.getAll();
        int rec = goodsTypeDAO.recordscount();

        assertEquals(rec, goodstype.size());
    }

    private GoodsType createGoodsType(String ItemDescription, String ItemModel , String ItemType) {
        GoodsType goodstype = new GoodsType();

        goodstype.setItemModel(ItemModel);
        goodstype.setItemDescription(ItemDescription);
        goodstype.setItemType(ItemType);
        return goodstype;
    }
}
