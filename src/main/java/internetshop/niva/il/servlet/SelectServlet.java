package internetshop.niva.il.servlet;

import internetshop.niva.il.database.jdbc.GoodsDAOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by voyager on 2015.11.03..q
 */
public class SelectServlet extends HttpServlet {
    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/SelectPage.jsp");
        requestDispatcher.forward(request, response);
    }
}
