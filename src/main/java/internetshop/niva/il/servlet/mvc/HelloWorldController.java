package internetshop.niva.il.servlet.mvc;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by voyager on 2015.11.03..
 */

public class HelloWorldController implements MVCController {

    public MVCModel execute(HttpServletRequest request) {
        return  new MVCModel("Hello from MVC", "/helloWorld.jsp");
    }

}
