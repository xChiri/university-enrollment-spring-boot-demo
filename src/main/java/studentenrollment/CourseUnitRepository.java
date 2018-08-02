package studentenrollment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseUnitRepository extends JpaRepository<CourseUnit, Integer> {
}
