package courseplus_ziyi.Service;


import courseplus_ziyi.Model.Course;
import courseplus_ziyi.Model.Student;
import courseplus_ziyi.Repository.CourseRepo;
import courseplus_ziyi.Repository.SemesterRepo;
import courseplus_ziyi.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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

	public List<Student> getAllStudents(){
		return sRepo.findAll();
	}


	public Optional<Student> getStudent(int id){
		return sRepo.findById(id);
	}

	public Student saveStudent(Student s) {
		try {
			uService.save(s.getUser());
			semRepo.save(s.getSemester());
			return sRepo.save(s);
		}
		catch(Exception e){
			e.getMessage();
			return null;
		}
	}

	@Transactional
	public String enrollCourse(String rollNo, Long courseId){
		Optional<Course> courseToEnroll = cRepo.findById(courseId);
		 Optional<Student>  studentFound = sRepo.findByRollNo(rollNo);
		 List<Course> existingCourse = studentFound.get().getCourses();
		 if(existingCourse.contains(courseToEnroll.get())) return "Already Enrolled in this Course !";
		 else existingCourse.add(courseToEnroll.get());
		return "Student has been enrolled in the course with ID = "+ courseId +" and Name = "+courseToEnroll.get().getDescription();
	}
}
