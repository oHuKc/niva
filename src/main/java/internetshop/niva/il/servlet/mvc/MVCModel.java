package internetshop.niva.il.servlet.mvc;

/**
 * Created by voyager on 2015.11.03..
 */
public class MVCModel {

    private  Object data;
    private  String viewName;


    public MVCModel (Object data, String viewName) {
        this.data = data;
        this.viewName = viewName;
    }

    public Object getData() {
        return  data;
    }

    public String getViewName() {
        return viewName;
    }
}
