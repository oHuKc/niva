package internetshop.niva.il.servlet.mvc;

/**
 * Created by voyager on 2015.11.03..
 */
import com.sun.javafx.collections.MappingChange;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MVCFilter implements Filter {

    private Map<String , MVCController> controllers;

    public void init(FilterConfig filterConfig) throws ServletException {

        controllers = new HashMap<String, MVCController>();
        controllers.put("/mvc", new HelloWorldController());
        controllers.put("/products", new ProductController());
        controllers.put("/shopcart", new ShoppingCartController());
        controllers.put("/select", new SelectController());
        controllers.put("/menu", new MenuController());
        controllers.put("/tv", new TVController());
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
