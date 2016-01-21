package internetshop.niva.il.servlet.mvc;

import internetshop.niva.il.database.CartDAO;
import internetshop.niva.il.database.DBException;
import internetshop.niva.il.database.ProductVATDAO;
import internetshop.niva.il.domain.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by ilugovecs on 2016.01.20..
 */
//@Component
@Controller
public class OrderStatusControllerImpl {

    @Autowired
    @Qualifier(value = "CartDAOImpl_Hibernate")
    private CartDAO cartdao;

    @Autowired
    @Qualifier(value = "ProductVatDAOImpl_Hibernate")
    private ProductVATDAO productvatdao;


    public String getCartRecords(HttpServletRequest req, HttpServletResponse resp)
            throws DBException, SQLException, IOException {


        int cartsize = cartdao.getAll().size();


       if (cartdao.getAll().size() != 0) {

           for (int i = 0; i < cartsize; i ++) {

               String productid = cartdao.getAll().get(i).getProductid();
               String productname = cartdao.getAll().get(i).getProductname();
               String productbrand = cartdao.getAll().get(i).getProductbrand();
               String productdescription = cartdao.getAll().get(i).getProductdescription();

               String cartrecord = productid + " " + productname + " " + productbrand +" "+ productdescription;


               req.setAttribute("crecords", cartrecord);

               System.out.print("Cart records: " + cartrecord + "\n" + "Cart Size :" + cartsize + "\n" + productdescription + "\n");

           }
       }
        return null;
    }


    public String getProductVatRecords(HttpServletRequest req, HttpServletResponse resp) throws DBException {

if ( productvatdao.getAll().size() !=0) {

    String pvatsize = String.valueOf(productvatdao.getAll().size());

    req.setAttribute("psize", pvatsize);
}
        return null;
    }



    @Transactional
    private Object twocontrollerscv(HttpServletRequest request, HttpServletResponse response)
            throws DBException, SQLException, IOException {

        HashMap<String, String> twocontrollerscv = new HashMap<String, String>();

        twocontrollerscv.put(getCartRecords(request, response), getProductVatRecords(request, response));

         return null;
    }

    /*
    @Transactional
    public MVCModel execute(HttpServletRequest request, HttpServletResponse response)
            throws DBException, SQLException, IOException {
        return new MVCModel(twocontrollerscv(request, response), "/OrderStatus.jsp");
    }
    */
    @RequestMapping(value = "/orderstatus", method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, DBException {

        return new ModelAndView("/OrderStatus.jsp", "model",twocontrollerscv(request, response) );
    }

}
