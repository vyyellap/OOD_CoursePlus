package courseplus_ziyi.controller;

import courseplus_ziyi.Model.Student;
import courseplus_ziyi.Model.UserDetails;
import courseplus_ziyi.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentResource {

	@Autowired
	StudentService studentService;
	@RequestMapping("")
	public String index() {
		return "Student Resource";
	}


	@PostMapping("/register")
	public String registerUser(@RequestBody UserDetails s){

		Student newStudent = studentService.saveStudent(new Student(s.getName(), s.getRollNo(),s.getUsername(), s.getPassword(),s.getEmail(),s.getSemName(),s.getSemYear()));
		if(newStudent == null)return "Student Registration Failed";
		else
			return  "Student Registered Successfully";
	}
	@GetMapping("/all")
	public List<Student> getAllUsers(){
		return studentService.getAllStudents();
	}

	@GetMapping("/{id}")
	public Student getUser(@PathVariable("id") int id){
		return studentService.getStudent(id).orElse( null);
	}

	@PostMapping("/enroll/{rollNo}/{courseId}")
	public String enrollStudent(@PathVariable("courseId") Long courseId, @PathVariable("rollNo") String rollNo){
		return studentService.enrollCourse(rollNo,courseId);
	}
}
