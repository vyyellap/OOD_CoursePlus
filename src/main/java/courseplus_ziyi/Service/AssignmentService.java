package courseplus_ziyi.Service;


import courseplus_ziyi.Model.Assignment;
import courseplus_ziyi.Repository.AssignmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

@Service
public class AssignmentService {
	@Autowired
	private AssignmentRepo repo;
	@Autowired
	HttpServletRequest request;
	@Value("${app.upload.dir:${user.home}}")
	public String uploadDir;
	@Autowired
	CourseService cService;

	@Autowired
	FileStorageService fileService;

	public void save(MultipartFile assignmentFile) {
		Assignment assignment = new Assignment();
		if (!request.getParameter("id").isEmpty())
			assignment.setId(Integer.parseInt(request.getParameter("id")));
		assignment.setName(request.getParameter("name"));
		assignment.setDescription(request.getParameter("description"));
		assignment.setDueDate(Date.valueOf(request.getParameter("dueDate")));
		assignment.setFilePath(fileService.storeFile(assignmentFile, "assignments"));
		assignment.setCourse(cService.findById(Integer.parseInt(request.getParameter("courseid"))));
		repo.save(assignment);

	}

	public List<Assignment> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
