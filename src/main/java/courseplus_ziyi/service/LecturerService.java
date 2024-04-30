package java.courseplus_ziyi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.courseplus_ziyi.model.Course;
import java.courseplus_ziyi.model.Lecturer;
import java.courseplus_ziyi.repo.LecturerRepo;

@Service
public class LecturerService {
	@Autowired
	LecturerRepo iRepo;
	@Autowired
	CourseService cService;

	public List<Course> findCoursesByLecturerUserName(String userName) {
		return cService.findCoursesByLecturerUserName(userName);
	}

	public Lecturer findInstByUserName(String userName) {
		return iRepo.findByUserUsername(userName);
	}

	public List<Lecturer> getLecturers() {
		List<Lecturer> instructors = iRepo.findAll();
		return instructors;
	}

	public Lecturer save(Lecturer instructor) {

		Lecturer tempInst = findInstByUserName(instructor.getUser().getUsername());
		if (tempInst != null && tempInst.getId() != instructor.getId()) {
			return null;
		}
		return iRepo.save(instructor);
	}

	public void delete(int id) {
		iRepo.deleteById(id);
	}

	public Lecturer findInstById(int id) {
		// TODO Auto-generated method stub
		return iRepo.findById(id).get();
	}

}
