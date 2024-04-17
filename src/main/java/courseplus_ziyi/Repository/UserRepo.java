package courseplus_ziyi.Repository;

import courseplus_ziyi.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
	Optional<User> findByUsername(String userName);
}
