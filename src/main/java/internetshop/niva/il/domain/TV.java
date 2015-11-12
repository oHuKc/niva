package internetshop.niva.il.domain;

import java.sql.Blob;
import java.util.List;

/**
 * Created by ilugovecs on 2015.11.05..
 */
public class TV {
    private long tvid;
    private String tvtype;
    private String tvscreensize;
    private String tvebrand;
    private String tvprice;
    private String tvresolution;
    private String tvdescription;
    private int tvscreentypeid;
    private Blob tvimage;

    public long getTvid() {return tvid;}

    public void setTvid(long tvid) {this.tvid = tvid;}

    public String getTvtype() {return  tvtype;}

    public void setTvtype(String tvtype) {this.tvtype = tvtype;}

    public String getTvscreensize() {return tvscreensize;}

    public void setTvscreensize(String tvscreensize) {this.tvscreensize = tvscreensize;}

    public String getTvebrand() {return tvebrand;}

    public void setTvebrand(String tvebrand) {this.tvebrand = tvebrand;}

    public String getTvprice() {return tvprice;}

    public void setTvprice(String tvprice) {this.tvprice = tvprice;}

    public String getTvresolution() {return tvresolution;}

    public void setTvresolution(String tvresolution){this.tvresolution = tvresolution;}

    public String getTvdescription() {return tvdescription;}

    public void setTvdescription(String tvdescription) {this.tvdescription = tvdescription;}

    public int getTvscreentypeid() {return tvscreentypeid;}

    public void setTvscreentypeid(int tvscreentypeid) {this.tvscreentypeid = tvscreentypeid;}

    public Blob getTvimage() {return tvimage;}

    public void setTvimage(Blob tvimage){this.tvimage = tvimage;}

}
