package internetshop.niva.il.domain;

/**
 * Created by Igor on 2015.10.19..
 */
public class Customer {

    private long userId;
    private String firstName;
    private String lastName;
    private String phonenr;
    private String email;


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
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
