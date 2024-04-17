package courseplus_ziyi.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@Entity
@Data
@Table(name = "student")
@EqualsAndHashCode(callSuper = false)
public class Student {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String rollNo;
	@ManyToOne
	private Semester semester;
	@OneToOne
	User user;

	public Student() {
	}

	public Student(String name, String rollno, String username, String password, String email) {
		setUser(new User(username, password, email, false,"ROLE_STUDENT"));
		this.name = name;
		this.rollNo = rollno;

	}

}
