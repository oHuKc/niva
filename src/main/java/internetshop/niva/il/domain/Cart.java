package internetshop.niva.il.domain;

import org.springframework.stereotype.Component;

/**
 * Created by ilugovecs on 2015.11.17..
 */
@Component
public class Cart {
    private long productid;
    private String productname;
    private String productbrand;
    private String productdescription;
    private String productstatus;
    private String productprice;

    public long getProductid() {return productid;}

    public void  setProductid(Long productid) {this.productid = productid;}

    public String getProductname() {return productname;}

    public void setProductname(String productname) {this.productname = productname;}

    public String getProductbrand() {return productbrand;}

    public void setProductbrand(String productbrand) {this.productbrand = productbrand;}

    public String getProductdescription() {return  productdescription;}

    public void setProductdescription(String productdescription) {this.productdescription = productdescription;}

    public String getProductstatus() {return  productstatus;}

    public void setProductstatus(String productstatus) {this.productstatus = productstatus;}

    public String getProductprice() {return productprice;}

    public void setProductprice(String productprice) {this.productprice = productprice;}
}
