package courseplus_ziyi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Table(name = "student")
@EqualsAndHashCode(callSuper = false)
public class Student{
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int sId;
	private String name;
	@Column(unique = true)
	private String rollNo;
	@ManyToOne
	private Semester semester;
	@OneToOne
	User user;

		@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_course", joinColumns = { @JoinColumn(referencedColumnName = "sId") }, inverseJoinColumns = {
			@JoinColumn(referencedColumnName = "id") })
		@JsonIgnore
	private List<Course> courses;

	public Student() {
	}

	public Student(String name, String rollno, String username, String password, String email, String SemName, String semYear) {
		setUser(new User(username, name,password, email, false,"ROLE_STUDENT"));
		setSemester(new Semester(SemName, semYear));
		this.name = name;
		this.rollNo = rollno;

	}

}
