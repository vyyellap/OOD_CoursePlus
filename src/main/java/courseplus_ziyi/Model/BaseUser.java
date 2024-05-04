package courseplus_ziyi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.userdetails.UserDetails;

// ABSTRACTION
public abstract class BaseUser implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Override
	@JsonIgnore
	public abstract boolean isAccountNonExpired();

	@Override
	@JsonIgnore
	public abstract boolean isAccountNonLocked();

	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
