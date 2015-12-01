package internetshop.niva.il.domain;

import javax.persistence.*;

/**
 * Created by Igor on 2015.10.19..
 */
/*@Entity*/
@Table(name = "customers")
public class Customer {

    @Id
    @Column(name="CustomerID", columnDefinition = "INT(10)")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @Column(name = "FirstName", columnDefinition = "CHAR(40)")
    private String firstName;

    @Column(name = "LastName", columnDefinition = "CHAR(40)")
    private String lastName;

    @Column(name = "PhoneNr", columnDefinition = "CHAR(20)")
    private String phonenr;

    @Column(name = "Email", columnDefinition = "CHAR(40)")
    private String email;

    public long getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getPhoneNr() {return phonenr;}

    public void setPhoneNr(String phonenr) {this.phonenr = phonenr;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

}
