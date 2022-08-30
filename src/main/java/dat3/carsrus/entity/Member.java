package dat3.carsrus.entity;

import dat3.security.entity.Role;
import dat3.security.entity.UserWithRoles;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Entity;




@NoArgsConstructor
@Entity
@Getter
@Setter
public class Member extends UserWithRoles {

    private String firstName;

    private String lastName;

    private String street;

    private String city;

    private String zip;

    private boolean approved;

    private Role role;

    private int ranking;

    public Member(String user, String password, String email, String firstName) {
        super(user, password, email);
        this.firstName = firstName;
    }

    public Member(String user, String password, String email, String firstName, String lastName, String street, String city, String zip, boolean approved, Role role) {
        super(user, password, email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.approved = approved;
        this.role = role;
    }

    public Member(String user, String password, String email, String firstName, String lastName, String street, String city, String zip) {
        super(user, password, email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }
}


