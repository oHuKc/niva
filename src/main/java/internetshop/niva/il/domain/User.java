package internetshop.niva.il.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by vitanovo on 07.12.2015.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "INT")
    private Long id;

    @Column(name = "email", columnDefinition = "VARCHAR(100)")
    private String email;

    @Column(name = "first_name", columnDefinition = "VARCHAR(50)")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "VARCHAR(50)")
    private String lastName;

    @Column(name = "password", columnDefinition = "VARCHAR(50)")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
