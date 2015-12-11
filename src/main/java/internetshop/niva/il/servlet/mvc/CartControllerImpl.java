package internetshop.niva.il.servlet.mvc;

import internetshop.niva.il.database.CartDAO;
import internetshop.niva.il.database.DBException;
import internetshop.niva.il.database.TVDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.sql.Blob;
import java.sql.SQLException;

/**
 * Created by ilugovecs on 2015.11.17..
 */

@Component
public class CartControllerImpl implements CartController {

    @Autowired
    @Qualifier(value = "CartDAOImpl_Hibernate")
    private CartDAO cartdaoimpl;


    @Autowired
    @Qualifier(value = "TVDAOImpl_Hibernate")
    private TVDAO tvdaoimpl;
    private int id = 0;

    public String getcart(HttpServletRequest req, HttpServletResponse resp)
            throws DBException, SQLException {

        Long getproductid = cartdaoimpl.getById(7L).getProductid();
        String getproductname = cartdaoimpl.getById(7L).getProductname();
        String getproductbrand = cartdaoimpl.getById(7L).getProductbrand();
        String getproductdescription = cartdaoimpl.getById(7L).getProductdescription();
        String getproductstatus = cartdaoimpl.getById(7L).getProductstatus();
        String getproductprice = cartdaoimpl.getById(7L).getProductprice();

        req.setAttribute("prodID", getproductid);
        req.setAttribute("prodName", getproductname);
        req.setAttribute("prodBrand", getproductbrand);
        req.setAttribute("prodDescripton", getproductdescription);
        req.setAttribute("status", getproductstatus);
        req.setAttribute("prodPrice", getproductprice);

        String uhd1 = String.valueOf(tvdaoimpl.get4KUHD(1).get(0).getTvscreensize());
        String uhd2 = String.valueOf(tvdaoimpl.get4KUHD(2).get(0).getTvscreensize());
        String uhd3 = String.valueOf(tvdaoimpl.get4KUHD(3).get(0).getTvscreensize());


        String cartlist = String.valueOf(cartdaoimpl.CartSelectHQL().get(0).getProductbrand());
        req.setAttribute("cartlist", cartlist);

        return  null;

    }

    @Transactional
    public MVCModel execute(HttpServletRequest request, HttpServletResponse response)
            throws DBException, SQLException, ServletException, Exception
    {
        //return  new MVCModel(getcart(request, response), "/helloWorld.jsp");
        return  new MVCModel(getcart(request, response), "/Cart.jsp");
    }
}
