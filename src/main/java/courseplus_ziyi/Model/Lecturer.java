package courseplus_ziyi.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "instructor")
public class Lecturer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String department;
	private String qualification;
	@OneToOne
	User user;


	public Lecturer(String username,String password, String email, String qualification, String name, String department) {
		setUser(new User(username, 	name,password, email, false, "ROLE_LECTURER"));
		this.qualification = qualification;
		this.department = department;
	}

}
