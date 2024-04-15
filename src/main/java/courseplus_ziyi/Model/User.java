package courseplus_ziyi.Model;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.sql.Date;

/**
 * User class
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String role;
    private String phone;
    private String email;
    //private String dob;
    private java.sql.Date dob;

    public User(String firstname, String lastname, String role, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.email = email;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    //	public String getDob() {
//		return dob;
//	}
//	public void setDob(String dob) {
//		this.dob = dob;
//	}
    public java.sql.Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
}