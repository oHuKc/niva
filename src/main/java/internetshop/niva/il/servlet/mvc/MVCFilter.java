package internetshop.niva.il.servlet.mvc;

/**
 * Created by voyager on 2015.11.03..
 */
import com.sun.javafx.collections.MappingChange;
import internetshop.niva.il.servlet.SpringConfig;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
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

/*
        controllers = new HashMap<String, MVCController>();
        controllers.put("/mvc", new HelloWorldController());
        controllers.put("/products", new ProductController());
        controllers.put("/shopcart", new ShoppingCartController());
        controllers.put("/select", new SelectController());
        controllers.put("/menu", new MenuController());
        controllers.put("/tv", new TVController());
        controllers.put("/cart", new CartController());
*/
        controllers = new HashMap<String, MVCController>();
        controllers.put("/mvc", getBean(HelloWorldController.class));
        controllers.put("/products", getBean(ProductController.class));
        controllers.put("/shopcart", getBean(ShoppingCartController.class));
        controllers.put("/select", getBean(SelectController.class));
        controllers.put("/menu", getBean(MenuController.class));
        controllers.put("/tv", getBean(TVController.class));
        controllers.put("/cart", getBean(CartController.class));

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
            MVCModel model = controller.execute(req);
            req.setAttribute("model", model.getData());
            ServletContext servletContext = req.getServletContext();
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(model.getViewName());
            requestDispatcher.forward(req, resp);

        }
        else filterchain.doFilter(request, response);
    }


    public void destroy() {

    }
}
