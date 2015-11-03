package internetshop.niva.il.servlet;

import internetshop.niva.il.domain.Goods;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by voyager on 2015.10.30..
 */
public class ShoppingCartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //resp.setContentType("text/html");

        //PrintWriter out = resp.getWriter();
        //out.println("<center>" + "Shopping Cart" + "</center>" );

        Goods goods = new Goods();
        goods.getGoodsName();
        req.setAttribute("price",goods);


        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ShoppingCart.jsp");
        requestDispatcher.forward(req, resp);
    }
}
