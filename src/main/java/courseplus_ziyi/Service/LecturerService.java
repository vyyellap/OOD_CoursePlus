package courseplus_ziyi.Service;


import courseplus_ziyi.Model.Course;
import courseplus_ziyi.Model.Lecturer;
import courseplus_ziyi.Repository.LecturerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturerService {
	@Autowired
	LecturerRepo lRepo;
	@Autowired
	UserService uService;
//	@Autowired
//	CourseService cService;

//	public List<Course> findCoursesByLecturerUserName(String userName) {
//		return cService.findCoursesByLecturerUserName(userName);
//	}

	public Lecturer findInstByUserName(String userName) {
		return lRepo.findByUserUsername(userName);
	}

	public List<Lecturer> getLecturers() {
		List<Lecturer> instructors = lRepo.findAll();
		return instructors;
	}

	public Lecturer saveLecturer(Lecturer instructor) {

//		Lecturer tempInst = findInstByUserName(instructor.getUser().getUsername());
//		if (tempInst != null && tempInst.getId() != instructor.getId()) {
//			return null;
//		}
		uService.save(instructor.getUser());
		return lRepo.save(instructor);
	}

	public void delete(int id) {
		lRepo.deleteById(id);
	}

	public Lecturer findInstById(int id) {
		// TODO Auto-generated method stub
		return lRepo.findById(id).get();
	}

}
