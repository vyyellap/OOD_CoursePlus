package courseplus_ziyi.Model;

import jakarta.persistence.Entity;

@Entity
public class Lecturer extends User {

    public Lecturer() {

    }

    public Lecturer(String displayName, String username, String gender, String password) {

        super(displayName, username, gender, password);
    }
}
