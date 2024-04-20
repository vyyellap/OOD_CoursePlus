package courseplus_ziyi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class Course implements Comparable<Course> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	@ManyToOne(optional = true)
	private Lecturer lecturer;
	@Transient
	private boolean isSelected;
	@Transient
	private boolean visible = true;
//	@JsonIgnore
	@ManyToMany(mappedBy = "courses")
	private List<Student> students;

	public Course(String description, Lecturer lecturer){
	this.description = description;
	this.lecturer = lecturer;
	}
	@Override
	public int compareTo(Course o) {
		// TODO Auto-generated method stub

		return (int) (id - o.id);
	}

	public Course(String description) {
		super();
		this.description = description;
	}


}
