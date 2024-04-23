package courseplus_ziyi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
@NoArgsConstructor
@ToString
public class User extends BaseUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique=true)
	protected String username;
	@Column(name = "name")
	private String name;
	protected String password;
	private boolean isAdmin;
	@Column(unique=true)
	private String email;
	private String role;

	public User(String username, String name, String password, String email, boolean isAdmin, String role) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.isAdmin = isAdmin;
		this.email = email;
		this.role = role;
	}

	public User(int id, String username, String password, String email, boolean isAdmin, String role) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.isAdmin = isAdmin;
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public String getRole() {
		return role;
	}
	public int getId() {
		return id;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	@Override @JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

//	@JsonIgnore
	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	@JsonProperty
	public void setName(String name) {
		this.name = name;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
