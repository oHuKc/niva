package internetshop.niva.il.servlet.mvc;

import internetshop.niva.il.database.CartDAO;
import internetshop.niva.il.database.DBException;
import internetshop.niva.il.database.TVDAO;
import internetshop.niva.il.domain.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by ilugovecs on 2015.11.17..
 */

@Component
public class CartControllerImpl extends HttpServlet implements CartController {

    @Autowired @Qualifier(value = "CartDAOImpl_Hibernate")
    private CartDAO cartdao;


    public String getCartSize(HttpServletResponse res, HttpServletRequest req)
            throws DBException {
        req.setAttribute("cartSize", cartdao.getAll().size());
        return null;
    }

    public String cartCondition(HttpServletResponse resp, HttpServletRequest req)
            throws DBException {

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
            throws DBException {
       // HttpSession session = req.getSession();
       String cartremoveid = req.getParameter("btnCartIDremove");
      //  String cartremoveid = seession.getParameter("btnCartIDremove");


        if (req.getParameter("btnCartIDremove") != null) {
            System.out.print("Candidate ID to remove:" + cartremoveid);
            cartdao.delete(cartremoveid);
        }
        return  cartremoveid;
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
