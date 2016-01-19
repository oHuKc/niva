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
    @Column(name = "LOGIN", columnDefinition = "VARCHAR(50)")
    private String login;

    @Column(name = "PASSWORD", columnDefinition = "VARCHAR(50)")
    private String password;

    public Long getId() {return  id;}

    public void setId(Long id) {this.id = id;}

    public String getLogin(){return  login;}

    public void  setLogin(String login) {this.login = login;}

    public String getPassword(){return password;}

    public void setPassword(String password) {this.password = password;}
}
