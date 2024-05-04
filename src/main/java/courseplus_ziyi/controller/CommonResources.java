package courseplus_ziyi.controller;


import courseplus_ziyi.Model.Course;
import courseplus_ziyi.Model.Lecturer;
import courseplus_ziyi.Service.CourseService;
import courseplus_ziyi.Service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommonResources {
	@Autowired
	CourseService cService;
	@Autowired
	LecturerService lService;

	@GetMapping("/get-all-courses")
	public List<Course> getCourseList() {
		return cService.findAll();
	}

	@GetMapping("/get-all-lecturers")
	public List<Lecturer> getLecturerList() {
		return lService.getLecturers();
	}
}
