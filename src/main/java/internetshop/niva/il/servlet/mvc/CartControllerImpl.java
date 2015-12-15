package internetshop.niva.il.servlet.mvc;

import internetshop.niva.il.database.CartDAO;
import internetshop.niva.il.database.DBException;
import internetshop.niva.il.database.TVDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
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
        Integer counter = (Integer)session.getAttribute("cartCount");

        if (counter == null) {
           // counter = 0L;
            counter = cartdao.getAll().size();
        }
        //counter++;
        session.setAttribute("cartCount", counter);
        req.setAttribute("cartCount", counter);
        return null;
    }

    @Transactional
    public MVCModel execute(HttpServletRequest request, HttpServletResponse response)
            throws  Exception

    {
     //   return new MVCModel(getCartSize(response, request), "/Cart.jsp");
        return new MVCModel(cartCondition(response, request), "/Cart.jsp");
    }


}
