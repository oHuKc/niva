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

    public String removeCartID(HttpServletResponse resp, HttpServletRequest req)
            throws DBException, SQLException {

        HttpSession session = req.getSession();

        if (session.getId() == session.getAttribute("sID") ) {
            String cartremoveid = req.getParameter("btnCartIDremove");

            if (req.getParameter("btnCartIDremove") != null) {

                System.out.print("Candidate ID to remove:" + cartremoveid + "\n");

                cartdao.delete(cartremoveid);

            }
        }
        return  null;
    }

    @Transactional
    public MVCModel execute(HttpServletRequest request, HttpServletResponse response)
            throws  Exception
    {
        return new MVCModel(removeCartID(response, request), "/Cart.jsp");
    }
}
