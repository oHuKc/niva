package internetshop.niva.il.servlet.mvc;

import internetshop.niva.il.database.CartDAO;
import internetshop.niva.il.database.DBException;
import internetshop.niva.il.database.TVDAO;
import internetshop.niva.il.domain.Cart;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
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

    private Integer ImageID = null;


    public String addToCart(HttpServletRequest req, HttpServletResponse resp)
            throws DBException, SQLException {

        String cartprodid = req.getParameter("btnCartTVid");
        String cartprodtype = req.getParameter("btnCartTVtype");
        String cartprodbrand = req.getParameter("btnCartTVbrand");
        String cartprodescr = req.getParameter("btnCartTVdescr");
        String cartprodprice = req.getParameter("btnCartTVprice");

        Cart cart = new Cart();
        //cart.setProductid(Long.valueOf(cartprodid));
        cart.setProductname(cartprodtype);
        cart.setProductbrand(cartprodbrand);
        cart.setProductdescription(cartprodescr);
        cart.setProductprice(cartprodprice);

        if (req.getParameter("btnCartTVid") != null) {
            System.out.println("TV Cart product id :" + cartprodid);

            cartdao.create(cart);
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

        HashMap<Integer, String> twocontrollers = new HashMap<Integer, String>();

        twocontrollers.put(getImage(request,response), addToCart(request,response));

        return null;
    }

    public MVCModel execute(HttpServletRequest request, HttpServletResponse response)
            throws Exception
    //{return  new MVCModel(addToCart(request, response), "/TV.jsp");}
    {return  new MVCModel(twocontrollers(request, response), "/TV.jsp");}


}
