package internetshop.niva.il.servlet.mvc;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ilugovecs on 2015.11.17..
 */
public class CartController implements MVCController {

    public MVCModel execute (HttpServletRequest request) {return  new MVCModel("", "/Cart.jsp");}
}
