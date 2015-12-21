package internetshop.niva.il.domain;

import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Igor on 2015.12.21..
 */
@Entity
@Table( name = "product_vat")
public class ProductVAT {

    @Id
    @GeneratedValue
    @Column( name = "PRODUCT_ID" , columnDefinition = "INT(10)")
    private String productid;

    @Column( name = "VAT_NAME", columnDefinition = "CHAR(40)")
    private String vatname;

    @Column ( name = "VAT", columnDefinition = "DECIMAL(10,2)")
    private String vat;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "PRODUCT_ID")
    @IndexColumn( name = "idx")
    private List<Cart> cart;


    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getVatname() { return  vatname ;}

    public void setVatname(String vatname) {this.vatname = vatname; }

    public List<Cart> getCart() {return cart;}

    public void setCart(List<Cart> cart) { this.cart = cart; }

}
