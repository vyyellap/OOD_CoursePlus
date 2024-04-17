package courseplus_ziyi.Repository;

import courseplus_ziyi.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface CourseRepo extends JpaRepository<Course, Long> {
	Optional<Course> findById(Long id);

	void deleteById(Long id);

	List<Course> findByLecturerUserUsername(String userName);

	@Query(value = "select id from course where description like %:value%", nativeQuery = true)
	List<Integer> searchCoursesByDescription(@PathVariable String value);
}
