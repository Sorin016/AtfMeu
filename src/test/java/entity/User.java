package entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "RegistrationTableForHibernate")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "Address")
    private String address;
    @Column(name = "City")
    private String city;
    @Column(name = "State")
    private String state;
    @Column(name = "ZipCode")
    private String zip;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "SSN")
    private String ssn;
    @Column(name = "Username")
    private String username;
    @Column(name = "Password")
    private String password;
    @Column(name = "ConfirmPassword")
    private String confirmPassword;

    public User(String firstName,
                String lastName,
                String address,
                String city,
                String state,
                String zip,
                String phone,
                String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.ssn = ssn;
    }

    public User(String username, String password, String confirmPassword) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public User() {
    }

}
