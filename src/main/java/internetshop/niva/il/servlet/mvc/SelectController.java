package internetshop.niva.il.servlet.mvc;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by voyager on 2015.11.03..
 */
@Component
public class SelectController implements MVCController{
    public MVCModel execute(HttpServletRequest request, HttpServletResponse response) {
        return  new MVCModel("","/SelectPage.jsp");
    }
}
