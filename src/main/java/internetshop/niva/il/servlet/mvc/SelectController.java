package internetshop.niva.il.servlet.mvc;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by voyager on 2015.11.03..
 */
public class SelectController implements MVCController{
    public MVCModel execute(HttpServletRequest request) {
        return  new MVCModel("","/SelectPage.jsp");
    }
}
