package internetshop.niva.il.servlet.mvc;

import internetshop.niva.il.database.CartDAO;
import internetshop.niva.il.database.DBException;
import internetshop.niva.il.database.ProductVATDAO;
import internetshop.niva.il.domain.Cart;
import internetshop.niva.il.domain.ProductVAT;
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
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ilugovecs on 2015.11.17..
 */

//@Component
@Controller
public class CartControllerImpl  {

    @Autowired
    @Qualifier(value = "CartDAOImpl_Hibernate")
    private CartDAO cartdao;

    public String removeCartID(HttpServletResponse resp, HttpServletRequest req)
            throws DBException, SQLException {

        HttpSession session = req.getSession();
        String cartremoveid = req.getParameter("btnCartIDremove");
        if (session.getId() == session.getAttribute("sID") ) {


            if (req.getParameter("btnCartIDremove") != null) {

                System.out.print("Candidate ID to remove:" + cartremoveid + "\n");

                cartdao.delete(cartremoveid);

            }
        }
        return  null;
    }
/*
    @Transactional
    public MVCModel execute(HttpServletRequest request, HttpServletResponse response)
            throws  Exception
    {
        return new MVCModel(removeCartID(response, request), "/Cart.jsp");
    }
*/
    @RequestMapping(value = "/cart", method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response)
            throws DBException, SQLException {

        return new ModelAndView("/Cart.jsp","model", removeCartID(response, request));
    }
}
