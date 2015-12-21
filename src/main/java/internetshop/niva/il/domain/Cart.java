package internetshop.niva.il.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by ilugovecs on 2015.11.17..
 */
@Entity
@Table( name  =  "cart", catalog = "niva_production",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "PRODUCT_NAME"),
        @UniqueConstraint(columnNames = "PRODUCT_BRAND")
})
public class Cart implements Serializable {



    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "INT")
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getProductid() {return productid;}

    public void  setProductid(String productid) {this.productid = productid;}

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
