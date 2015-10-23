package internetshop.niva.il.database.jdbc;

import internetshop.niva.il.database.DBException;
import internetshop.niva.il.domain.Goods;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by Igor on 2015.10.21..
 */
public class GoodsDAOImplTest extends TestCase {

    private DbCleaner databaseCleaner = new DbCleaner();
    private GoodsDAOImpl goodsDAO = new GoodsDAOImpl();

    @Before
    public void init() throws DBException {
        try {
            databaseCleaner.cleanDatabase();
        } catch (DBException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testCreate() throws DBException, SQLException {

        Goods gds = createGoods("Computers", "PC386i", "$455,67", "PC station");

        goodsDAO.create(gds);

        Goods gdsFromDB = goodsDAO.getById(gds.getGoodsId());
        assertNotNull(gdsFromDB);
        assertEquals(gds.getGoodsId(), gdsFromDB.getGoodsId());
        assertEquals(gds.getGoodsType(), gdsFromDB.getGoodsType());
        assertEquals(gds.getGoodsName(), gdsFromDB.getGoodsName());
        assertEquals(gds.getGoodsPrice(), gdsFromDB.getGoodsPrice());
        assertEquals(gds.getGoodsDesription(), gdsFromDB.getGoodsDesription());
    }

   @Test
    public void testMultipleGoodsAdd() throws DBException, SQLException{

        Goods goods1 = createGoods("Computers PC", "PC386i", "$455,67", "PC station");
        Goods goods2 = createGoods("Desktop PC", "Toshiba", "$1422,67", "PC desktop toshiba");
        Goods goods3 = createGoods("Desktop PC", "Lenovo", "$800", "PC desktop Lenovo");
        Goods goods4 = createGoods("Desktop PC", "Asus", "$200,34", "PC desktop Asus");
        Goods goods5 = createGoods("Computers PC", "Intel Celeron n545 @3,5Gz","$855,78", "PC station Intel Celeron Quad Core");
        Goods goods6 = createGoods("Mobile Phone", "HTC one M8", "$800", "HTC one M8 mobile phone $800");
        Goods goods7 = createGoods("Mobile Phone", "Nexus6p", "$900", "Nexus6p Google phone $900");
        Goods goods8 = createGoods("Mobile Phone", "Iphone5", "$600,07", "Iphone5 IOS phone $600,07");
        Goods goods9 = createGoods("TV","Samsung TV" ,"$1455", "TV SAMSUNG 42 LED DLNA, WiFi $1455");
        Goods goods10 = createGoods("TV", "LG", "$855,33", "TV LG 40");
        goodsDAO.create(goods1);
        goodsDAO.create(goods2);
        goodsDAO.create(goods3);
        goodsDAO.create(goods4);
        goodsDAO.create(goods5);
        goodsDAO.create(goods6);
        goodsDAO.create(goods7);
        goodsDAO.create(goods8);
        goodsDAO.create(goods9);
        goodsDAO.create(goods10);

        List<Goods> goods = goodsDAO.getAll();
        int rec = goodsDAO.recordscount();

        assertEquals(rec, goods.size());
    }
    private Goods createGoods(String goodstype, String goodsname, String goodsprice, String goodsdescription) {
        Goods goods = new Goods();
        goods.setGoodsType(goodstype);
        goods.setGoodsName(goodsname);
        goods.setGoodsPrice(goodsprice);
        goods.setGoodsDescription(goodsdescription);
        return goods;
    }


}
