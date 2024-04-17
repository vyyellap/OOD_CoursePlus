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
	@Column(name = "name")
	private String name;
	private String qualification;
	@OneToOne
	User user;


	public Lecturer(String username, String password, String email, String qualification, String name) {
		setUser(new User(username, password, email, false, "ROLE_LECTURER"));
		this.name = name;
		this.qualification = qualification;
	}

}
