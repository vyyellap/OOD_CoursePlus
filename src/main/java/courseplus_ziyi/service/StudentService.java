package java.courseplus_ziyi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.courseplus_ziyi.model.Student;
import java.courseplus_ziyi.repo.StudentRepo;
import java.courseplus_ziyi.repo.UserRepo;

@Service
public class StudentService {
	@Autowired
	StudentRepo repo;

	@Autowired
	PasswordEncoder encoder;
	@Autowired
	UserService uService;

	public void saveStudent(Student s) {
		uService.save(s.getUser());
		repo.save(s);
	}
}
