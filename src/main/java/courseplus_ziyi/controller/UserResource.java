package courseplus_ziyi.controller;


import courseplus_ziyi.Model.User;
import courseplus_ziyi.Service.UserService;
import courseplus_ziyi.jwt.JwtUtil;

import courseplus_ziyi.security.JwtRequest;
import courseplus_ziyi.security.JwtResponse;
import courseplus_ziyi.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
public class UserResource {

	@Autowired
	UserService userService;
	@Autowired
	JwtUtil jUtil;
	@Autowired
	PasswordEncoder en;

	@Autowired
	private JWTUtility jwtUtility;

	@Autowired
	private AuthenticationManager authenticationManager;

//	@PostMapping("/auth")
//	public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) throws Exception {
//		User userDetails = userService.findByUserName(authRequest.getUsername(), authRequest.getPassword());
//		if (userDetails != null) {
//			final String jwt = jUtil.generateToken(userDetails);
//			JwtResponse res = new JwtResponse(jwt, userDetails.getUsername(), userDetails.getRole());
//			// AuthResponse res = new AuthResponse(jwt, userDetails.getUsername(), false);
//			return ResponseEntity.ok(res);
//		} else {
//			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid Username or password");
//		}
//	}

	@PostMapping("/login")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							jwtRequest.getUsername(),
							jwtRequest.getPassword()
					)
			);
		} catch (BadCredentialsException e) {
			return new JwtResponse("","INVALID CREDENTIALS");
		}

		final UserDetails userDetails
				= userService.loadUserByUsername(jwtRequest.getUsername());

		final String token =
				jwtUtility.generateToken(userDetails);

		return  new JwtResponse(token,"Credentials VERIFIED. LOGIN SUCCESSFUL !!!");
	}

	@PostMapping("/auth/check-password")
	public boolean checkPassword(@RequestBody JwtRequest authRequest) {
		return userService.checkPassword(authRequest);
	}

	@GetMapping("/users")
	public List<User> getUsers() {
		List<User> allUsers = userService.getAllUsers();
		System.out.println("Getting all users " + allUsers);
		return allUsers;
	}

	@PostMapping("/users")
	public User save(@RequestBody User user) {
		return userService.save(user);
	}

	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}

	@GetMapping("/users/get/{username}")
	public User getUserByUserName(@PathVariable String username) {
		return userService.findByUserName(username);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		if (userService.delete(id)) {
			return ResponseEntity.ok(null);
		} else {
			return ResponseEntity.ok("cannot delete admin account");
		}
	}

	@GetMapping("users/en-pass")
	@ResponseBody
	public String encryptPassword() {
		userService.getAllUsers().forEach(user -> {
			user.setPassword(en.encode(user.getPassword()));
			System.out.println(user);
			userService.save(user);
		});

		return "All Password encoded successfully";
	}


}
