package courseplus_ziyi.Service;


import courseplus_ziyi.Model.Course;
import courseplus_ziyi.Model.Semester;
import courseplus_ziyi.Model.Student;
import courseplus_ziyi.Repository.CourseRepo;
import courseplus_ziyi.Repository.SemesterRepo;
import courseplus_ziyi.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
	@Autowired
	StudentRepo sRepo;

	@Autowired
	SemesterRepo semRepo;

	@Autowired
	CourseRepo cRepo;

//	@Autowired
//	PasswordEncoder encoder;
	@Autowired
	UserService uService;

	public void saveStudent(Student s) {
		uService.save(s.getUser());
		semRepo.save(s.getSemester());
		sRepo.save(s);
	}

	@Transactional
	public void enrollCourse(String rollNo, Long courseId){
		Optional<Course> courseToEnroll = cRepo.findById(courseId);
		 Optional<Student>  studentFound = sRepo.findByRollNo(rollNo);
		 studentFound.get().getCourses().add(courseToEnroll.get());

	}
}
