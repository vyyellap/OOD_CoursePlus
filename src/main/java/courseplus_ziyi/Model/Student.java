package courseplus_ziyi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

// ENCAPSULATION
// bundling of data and methods that operate on that data within a single unit called "CLASS"
// Here we have made our variables private,so they can not be used outside class, and we have our public methods to
// use the variables outside class
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

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
