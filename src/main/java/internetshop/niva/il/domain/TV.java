package internetshop.niva.il.domain;




import javax.persistence.*;
import java.sql.Blob;
import java.util.List;

/**
 * Created by ilugovecs on 2015.11.05..
 */
@Entity
@Table( name = "tv_hometheater")
public class TV {
    @Id
    @Column( name = "id", columnDefinition = "INT(11)")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tvid;

    @Column( name = "TV_TYPE", columnDefinition = "CHAR(40)")
    private String tvtype;

    @Column( name = "TV_SCREEN_SIZE", columnDefinition = "CHAR(40)")
    private String tvscreensize;

    @Column( name = "BRAND", columnDefinition = "CHAR(40)")
    private String tvebrand;

    @Column( name = "PRICE", columnDefinition = "CHAR(40)")
    private String tvprice;

    @Column( name = "RESOLUTION", columnDefinition = "CHAR(40)")
    private String tvresolution;

    @Column( name = "DESCRIPTION", columnDefinition = "CHAR(100)")
    private String tvdescription;

    @Column( name = "SCREEN_TYPE_ID", columnDefinition = "INT(10)")
    private int tvscreentypeid;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column( name = "IMAGE", columnDefinition = "longblob")
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
