package java.courseplus_ziyi.repository;

import java.courseplus_ziyi.Coursework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseworkRepository extends JpaRepository<Coursework, Long> {
}
