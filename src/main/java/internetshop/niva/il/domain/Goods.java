package internetshop.niva.il.domain;

/**
 * Created by ilugovecs on 2015.10.21..
 */
public class Goods {

    private long goodsid;
    private String goodstype;
    private String goodsname;
    private String goodsprice;
    private String goodsdescription;


    public long getGoodsId() {return goodsid;}

    public void setGoodsId(long goodsId) {this.goodsid = goodsId;}

    public String getGoodsType() {return goodstype;}

    public void setGoodsType(String goodstype) {this.goodstype = goodstype;}

    public String getGoodsName() {return  goodsname;}

    public void setGoodsName(String goodsname) {this.goodsname = goodsname;}

    public String getGoodsPrice(){return goodsprice;}

    public void setGoodsPrice(String goodsprice) {this.goodsprice = goodsprice;}

    public String getGoodsDesription() {return goodsdescription;}

    public void setGoodsDescription(String goodsdescription) {this.goodsdescription = goodsdescription;}


}
