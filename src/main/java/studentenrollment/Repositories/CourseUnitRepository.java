package studentenrollment.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentenrollment.Models.CourseUnit;

@Repository
public interface CourseUnitRepository extends JpaRepository<CourseUnit, Integer> {
}
