package internetshop.niva.il.servlet.mvc;

import internetshop.niva.il.database.CartDAO;
import internetshop.niva.il.database.DBException;
import internetshop.niva.il.database.ProductVATDAO;
import internetshop.niva.il.database.TVDAO;
import internetshop.niva.il.domain.Cart;
import internetshop.niva.il.domain.ProductVAT;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ilugovecs on 2015.11.26..
 */
@Component
public class AddToCartControllerImpl implements  AddToCartController {

    @Autowired
    @Qualifier(value = "CartDAOImpl_Hibernate")
    private CartDAO cartdao;

    @Autowired
    @Qualifier(value = "TVDAOImpl_Hibernate")
    private TVDAO tvdaoimpl;

    @Autowired
    @Qualifier(value = "ProductVatDAOImpl_Hibernate")
    private ProductVATDAO productVATDAO;

    private Integer ImageID = null;

    public String addToCart(HttpServletRequest req, HttpServletResponse resp)
            throws DBException, SQLException {

        String cartprodid = req.getParameter("btnCartTVid");
        String cartprodtype = req.getParameter("btnCartTVtype");
        String cartprodbrand = req.getParameter("btnCartTVbrand");
        String cartprodescr = req.getParameter("btnCartTVdescr");
        String cartprodprice = req.getParameter("btnCartTVprice");

        ProductVAT pvat = new ProductVAT();

        Cart cart = new Cart();
        cart.setProductid(cartprodid);
        cart.setProductname(cartprodtype);
        cart.setProductbrand(cartprodbrand);
        cart.setProductdescription(cartprodescr);
        cart.setProductprice(cartprodprice);

        if (req.getParameter("btnCartTVid") != null) {

            pvat.setCart(new ArrayList<Cart>());
            pvat.getCart().add(cart);
            productVATDAO.create(pvat);
            HttpSession session = req.getSession();
            String idaddcarcount =  req.getParameter("idAddCartCount");
            session.setAttribute("addCartCount", idaddcarcount );
        }
        return cart.toString();
    }

    private Integer getImage(HttpServletRequest req,
                             HttpServletResponse resp) throws
            HibernateException, IOException, DBException, SQLException {
        Connection connection = null;
        if (req.getParameter("imgID") != null) {
            try {
                ImageID = Integer.parseInt(req.getParameter("imgID"));
                byte[] imgData = tvdaoimpl.getImage(ImageID);
                resp.setContentType("image/jpeg");
                OutputStream outputStream = resp.getOutputStream();
                outputStream.write(imgData);
                resp.getOutputStream().flush();
                resp.getOutputStream().close();
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
        return ImageID;

    }

    @Transactional
    private Object twocontrollers(HttpServletRequest request, HttpServletResponse response)
            throws DBException, SQLException, IOException {

        HttpSession session = request.getSession();

        if ( session.getId() == session.getAttribute("sID") ) {

            HashMap<Integer, String> twocontrollers = new HashMap<Integer, String>();

            twocontrollers.put(getImage(request, response), addToCart(request, response));
        } else {
            PrintWriter out = response.getWriter();
            out.println("<h1>" + "Wrong Session !" + "</h1>");
        }
        return null;
    }

    public MVCModel execute(HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {return  new MVCModel(twocontrollers(request, response), "/TV.jsp");}


}
