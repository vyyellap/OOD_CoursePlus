package courseplus_ziyi.Model;

import jakarta.persistence.Entity;

@Entity
public class Lecturer extends User {



    public Lecturer(String firstName, String lastName, String role, String email) {

        super(firstName, lastName, role, email);
    }
}
