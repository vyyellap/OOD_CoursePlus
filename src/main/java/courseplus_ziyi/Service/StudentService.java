package courseplus_ziyi.Service;


import courseplus_ziyi.Model.Student;
import courseplus_ziyi.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
