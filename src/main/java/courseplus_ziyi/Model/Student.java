package courseplus_ziyi.Model;


import jakarta.persistence.*;

@Entity
public class Student extends User {

    public Student(String firstName, String lastname, String role, String email) {

        super(firstName, lastname, role, email);
    }

}
