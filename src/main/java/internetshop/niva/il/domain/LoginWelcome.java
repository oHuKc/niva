package internetshop.niva.il.domain;

import javax.annotation.Generated;
import javax.persistence.*;
import java.sql.Date;

/**
 * Created by ilugovecs on 2016.01.18..
 */
@Entity
@Table(name = "welcome")
public class LoginWelcome {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", columnDefinition = "INT")
    private Long id;

    @Id
    @Column(name = "USERNAME", columnDefinition = "VARCHAR(50)")
    private String username;

    @Column(name = "PASSWORD", columnDefinition = "VARCHAR(50)")
    private String password;

    public Long getId() {return  id;}

    public void setId(Long id) {this.id = id;}

    public String getUsername(){return  username;}

    public void  setUsername(String username) {this.username = username;}

    public String getPassword(){return password;}

    public void setPassword(String password) {this.password = password;}
}
