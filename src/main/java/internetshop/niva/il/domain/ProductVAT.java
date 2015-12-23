package internetshop.niva.il.domain;

import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Igor on 2015.12.21..
 */
@Entity
@Table( name = "product_vat")
public class ProductVAT {

    @Id
    @GeneratedValue
    @Column( name = "ORDER_ID" , columnDefinition = "INT(10)")
    private String orderid;

    @Column (name =  "DATE", columnDefinition = "timestamp")
    private String tabledate;

    @Column( name = "VAT_NAME", columnDefinition = "CHAR(40)")
    private String vatname;

    @Column ( name = "VAT", columnDefinition = "DECIMAL(10,2)")
    private String vat;

    @Column ( name = "PRICE", columnDefinition = "DECIMAL(10,2)")
    private String price;

    @Column (name = "PRICE_TOTAL", columnDefinition = "DECIMAL(10,2)")
    private String pricetotal;

    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="ORDER_ID")
    private List<Cart> cart;


    public String getOrderid() {return orderid;}

    public void setProductid(String productid) {this.orderid = productid;}

    public String getTabledate() {return  tabledate;}

    public  void setTabledate(String  tabledate) {this.tabledate = tabledate;}

    public String getVat() { return  vat;}

    public void setVat(String vat) {this.vat = vat; }

    public String getVatname() { return  vatname ;}

    public void setVatname(String vatname) {this.vatname = vatname; }

    public String getPrice() { return  price;}

    public void setPrice(String price) {this.price = price;}

    public String getPricetotal() {return  pricetotal;}

    public void setPricetotal(String pricetotal) {this.pricetotal = pricetotal;}

    public List<Cart> getCart() {return cart;}

    public void setCart(List<Cart> cart) { this.cart = cart; }


}
