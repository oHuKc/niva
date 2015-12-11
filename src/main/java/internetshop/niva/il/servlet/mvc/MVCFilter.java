package internetshop.niva.il.servlet.mvc;

/**
 * Created by voyager on 2015.11.03..
 */

import internetshop.niva.il.database.DBException;
import internetshop.niva.il.servlet.spring.SpringConfig;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MVCFilter implements Filter {

    private Map<String , MVCController> controllers;

    private static final Logger logger = Logger.getLogger(MVCFilter.class.getName());

    private ApplicationContext springContext;

    public void init(FilterConfig filterConfig) throws ServletException {

        try {
            springContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        } catch (BeansException e) {
            logger.log(Level.INFO, "Spring context failed to start", e);
        }

        controllers = new HashMap<String, MVCController>();
        controllers.put("/mvc", getBean(HelloWorldController.class));
        controllers.put("/menu", getBean(MenuController.class));
        controllers.put("/products", getBean(ProductController.class));
        controllers.put("/shopcart", getBean(CartController.class));
        controllers.put("/select", getBean(SelectController.class));
        controllers.put("/menu", getBean(MenuController.class));
        controllers.put("/tv", getBean(TVController.class));
        controllers.put("/cart", getBean(CartController.class));
        controllers.put("/tv", getBean(ImageShowController.class));
        controllers.put("/add", getBean(CartController.class));
        controllers.put("/login", getBean(LoginController.class));
    }

    private MVCController getBean(Class clazz){
        return (MVCController) springContext.getBean(clazz);
    }

    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterchain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String contextURI = req.getServletPath();
        MVCController controller = controllers.get(contextURI);



        if (controller != null) {
            MVCModel model = null;
            try {
                model = controller.execute(req, resp);
            } catch (DBException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            req.setAttribute("model", model.getData());
            ServletContext servletContext = req.getServletContext();
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(model.getViewName());
           if (!resp.isCommitted()) { //To remove SEVERE: Servlet.service() for servlet [default] Exception

                requestDispatcher.forward(req, resp);
            }
        }
        else filterchain.doFilter(request, response);
    }


    public void destroy() {

    }
}
