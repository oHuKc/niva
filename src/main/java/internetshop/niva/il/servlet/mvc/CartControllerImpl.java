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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by ilugovecs on 2015.11.17..
 */

@Component
public class CartControllerImpl implements CartController {

    @Autowired @Qualifier(value = "CartDAOImpl_Hibernate")
    private CartDAO cartdao;


    public String getCartSize(HttpServletResponse res, HttpServletRequest req)
            throws DBException {
        req.setAttribute("cartSize", cartdao.getAll().size());
        return null;
    }




    @Transactional
    public MVCModel execute(HttpServletRequest request, HttpServletResponse response)
            throws DBException, SQLException, ServletException, Exception
    {
            return new MVCModel(getCartSize(response, request), "/Cart.jsp");

    }




}
