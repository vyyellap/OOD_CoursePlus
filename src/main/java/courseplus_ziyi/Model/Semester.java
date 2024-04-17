package courseplus_ziyi.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Semester {
	@Id
	@GeneratedValue
	private int id;
	private String semesterName;
	private String semester;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "sem_course", joinColumns = { @JoinColumn(referencedColumnName = "id") }, inverseJoinColumns = {
			@JoinColumn(referencedColumnName = "id") })
	private List<Course> courseList;


}
