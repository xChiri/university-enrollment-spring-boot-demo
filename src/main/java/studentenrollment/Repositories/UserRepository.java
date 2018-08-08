package studentenrollment.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import studentenrollment.Models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
