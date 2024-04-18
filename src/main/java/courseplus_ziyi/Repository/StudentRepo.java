package courseplus_ziyi.Repository;

import courseplus_ziyi.Model.Student;
import courseplus_ziyi.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Integer> {

    Optional<Student> findByRollNo(String roll);
}
