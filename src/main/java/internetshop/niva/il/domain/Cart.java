package internetshop.niva.il.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ilugovecs on 2015.11.17..
 */
@Entity
@Table( name  =  "cart")
public class Cart implements Serializable {

    @ManyToOne
    @JoinColumn( name = "ORDER_ID",
            insertable = false, updatable = false,
            nullable = false)
    private ProductVAT orderid;

    @Id
    @Column( name = "PRODUCT_ID", columnDefinition = "INT(10)")
    private String productid;


    @Column( name = "PRODUCT_NAME", columnDefinition = "CHAR(40)")
    private String productname;

    @Column( name = "PRODUCT_BRAND", columnDefinition = "CHAR(40)")
    private String productbrand;

    @Column( name = "PRODUCT_DESCRIPTION", columnDefinition = "CHAR(100)")
    private String productdescription;

    @Column( name = "STATUS", columnDefinition = "CHAR(40)")
    private String productstatus;

    @Column( name = "PRICE", columnDefinition = "DECIMAL(10,2)")
    private String productprice;

    @Column ( name = "TOTAL", columnDefinition = "DECIMAL(10,2)")
    private String total;

    public ProductVAT getId() {
        return orderid;
    }

    public void setId(ProductVAT orderid) {
        this.orderid = orderid;
    }


    public String getProductid() {return productid;}

    public void  setProductid(String productid) {this.productid = productid;}

    public Cart() {

    }
    public Cart (ProductVAT orderid, String productid, String productname,
                 String  productbrand, String  productdescription,
                 String productstatus, String productprice ) {
        this.orderid = orderid;
        this.productname = productname;
        this.productbrand = productbrand;
        this.productdescription = productdescription;
        this.productstatus = productstatus;
        this.productprice = productprice;
        this.productid = productid;
    }


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

    public String getTotal() {return total;}

    public void setTotal(String total) {this.total = total;}
}
