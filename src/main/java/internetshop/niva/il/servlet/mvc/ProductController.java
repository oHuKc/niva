package internetshop.niva.il.servlet.mvc;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by voyager on 2015.11.03..
 */
@Component
public class ProductController implements MVCController {
    public MVCModel execute(HttpServletRequest request) {
        return new MVCModel("","/ProductPage.jsp");
    }
}
