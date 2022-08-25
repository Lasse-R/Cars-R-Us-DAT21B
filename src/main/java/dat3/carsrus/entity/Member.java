package dat3.carsrus.entity;

import dat3.security.entity.Role;
import dat3.security.entity.UserWithRoles;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Member extends UserWithRoles {


    private String firstName;



    private String lastName;


    private String street;


    private String city;


    private int zipCode;


    private boolean approved;

    private Role role;

    public Member() {

    }

    public Member(String user, String password, String email, String firstName) {
        super(user, password, email);
        this.firstName = firstName;
    }

    public Member(String user, String password, String email, String firstName, String lastName, String street,
                  String city, int zipCode, boolean approved, Role role) {
        super(user, password, email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this. zipCode = zipCode;
        this.approved = approved;
        this.role = role;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
