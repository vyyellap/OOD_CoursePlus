package courseplus_ziyi.Repository;

import courseplus_ziyi.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
