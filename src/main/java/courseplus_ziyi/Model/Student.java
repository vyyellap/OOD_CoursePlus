package courseplus_ziyi.Model;


import jakarta.persistence.*;

@Entity
public class Student extends User {

    public Student() {

    }

    public Student(String displayName, String username, String gender, String password) {

        super(displayName, username, gender, password);
    }

}
