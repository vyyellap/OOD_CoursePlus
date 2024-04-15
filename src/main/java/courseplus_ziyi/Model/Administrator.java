package courseplus_ziyi.Model;

import jakarta.persistence.Entity;


@Entity
public class Administrator extends User {

    public Administrator(String firstName, String lastName, String role, String email) {

        super(firstName, lastName, role, email);
    }
}
