package internetshop.niva.il.servlet.mvc;

import internetshop.niva.il.database.CartDAO;
import internetshop.niva.il.database.DBException;
import internetshop.niva.il.database.ProductVATDAO;
import internetshop.niva.il.domain.Cart;
import internetshop.niva.il.domain.ProductVAT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ilugovecs on 2015.11.17..
 */

@Component
public class CartControllerImpl extends HttpServlet implements CartController {

    @Autowired @Qualifier(value = "CartDAOImpl_Hibernate")
    private CartDAO cartdao;

    @Autowired
    @Qualifier(value = "ProductVatDAOImpl_Hibernate")
    private ProductVATDAO productVATDAO;

    public String getCartSize(HttpServletResponse res, HttpServletRequest req)
            throws DBException {
        req.setAttribute("cartSize", cartdao.getAll().size());
        return null;
    }

    public String cartCondition(HttpServletResponse resp, HttpServletRequest req)
            throws DBException, SQLException {

        HttpSession session = req.getSession();
        //Integer counter = (Integer)session.getAttribute("cartCount");
       Integer counter = (Integer)session.getAttribute("btnCartTVid");

        if (session.getAttribute("btnCartTVid") == null) {
           //counter = 0;
           counter = cartdao.getAll().size();
        }
        //counter++;
        session.setAttribute("cartCount", counter);
        req.setAttribute("cartCount", counter);
        return null;
    }

    public String removeCartID(HttpServletResponse resp, HttpServletRequest req)
            throws DBException, SQLException {

         HttpSession session = req.getSession();

         String cartremoveid = req.getParameter("btnCartIDremove");
         String removeid = (String) session.getAttribute("removeid");

        //req.getParameter("btnCartIDremove")
        //ProductVAT cartremoveid = productVATDAO.getById("85");

       // ProductVAT cartremoveid = productVATDAO.getById(req.getParameter("btnCartIDremove"));
       // ProductVAT pvat = new ProductVAT();

        if (req.getParameter("btnCartIDremove") != null) {

            System.out.print("Candidate ID to remove:" + cartremoveid +"\n");
            System.out.print("Product ID to remove:" + removeid +"\n");
           // Cart cart = new Cart();
           // cart.setProductid(cartremoveid);
            cartdao.delete(cartremoveid);
           // pvat.setCart(new ArrayList<Cart>());
           // pvat.getCart().add(cart);
           // productVATDAO.delete(String.valueOf(pvat));
        }
        return  null;
    }

    @Transactional
    private Object twocontrollers(HttpServletRequest request, HttpServletResponse response)
            throws DBException, SQLException, IOException {

        HashMap<String, String> twocontrollers = new HashMap<String, String>();

        twocontrollers.put(cartCondition(response, request), removeCartID(response, request));

        return null;
    }

    @Transactional
    public MVCModel execute(HttpServletRequest request, HttpServletResponse response)
            throws  Exception
    {
        //return new MVCModel(getCartSize(response, request), "/Cart.jsp");
        //return new MVCModel(removeCartID(response, request), "/Cart.jsp");
        return new MVCModel(twocontrollers(request, response), "/Cart.jsp");
    }


}
