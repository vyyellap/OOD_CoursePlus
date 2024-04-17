package courseplus_ziyi.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//public class AuthResponse {
//	private final String jwt;
//	private String username;
//	private String role;
//}

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {

	private String jwtToken;
}
