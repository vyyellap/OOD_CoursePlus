package courseplus_ziyi.Service;


import courseplus_ziyi.Model.Semester;
import courseplus_ziyi.Repository.SemesterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SemesterService {
	@Autowired
	SemesterRepo repo;

	public void save(Semester sem) {
		repo.save(sem);
	}

	public Semester findById(int id) {
		Optional<Semester> sem = repo.findById(id);
		return !sem.isPresent() ? null : sem.get();
	}

	public List<Semester> getAll() {
		return repo.findAll();
	}

}
