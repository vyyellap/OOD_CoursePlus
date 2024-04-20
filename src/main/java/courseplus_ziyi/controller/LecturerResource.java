package courseplus_ziyi.controller;


import courseplus_ziyi.Model.Lecturer;
import courseplus_ziyi.Model.Student;
import courseplus_ziyi.Model.UserDetails;
import courseplus_ziyi.Service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lecturer")
public class LecturerResource {

	@Autowired
	LecturerService iService;

	@PostMapping("/register")
	public String registerUser(@RequestBody UserDetails s){

		Lecturer newLecturer = iService.saveLecturer(new Lecturer(s.getUsername(), s.getPassword(),s.getEmail(),s.getQualification(),s.getName(),s.getDepartment()));
		if(newLecturer == null)return "Lecturer Registration Failed";
		else
			return  "Lecturer  Registered Successfully";
	}

	@GetMapping("")
	public List<Lecturer> getAllLecturers() {
		return iService.getLecturers();
	}

	@PostMapping("/save")
	public ResponseEntity<Lecturer> save(@RequestBody Lecturer instructor) {
		
		Lecturer i = iService.saveLecturer(instructor);
		if (i != null) {
			return ResponseEntity.ok().body(i);
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteLecturer(@PathVariable int id) {
		iService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{username}")
	public Lecturer getLecturer(@PathVariable String username) {
		return iService.findInstByUserName(username);
	}
	@GetMapping("/id/{id}")
	public Lecturer getLecturerByID(@PathVariable int id) {
		return iService.findInstById(id);
	}
}
