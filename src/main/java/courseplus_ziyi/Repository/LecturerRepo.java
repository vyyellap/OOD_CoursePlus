package courseplus_ziyi.Repository;

import courseplus_ziyi.Model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturerRepo extends JpaRepository<Lecturer, Integer> {
	Lecturer findByUserUsername(String userName);
}
