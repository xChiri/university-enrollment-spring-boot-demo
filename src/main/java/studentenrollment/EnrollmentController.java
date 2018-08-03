package studentenrollment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class EnrollmentController {

    @Autowired
    private EnrollmentRepository enrollmentRepository;
    
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseUnitRepository courseUnitRepository;

    @GetMapping("/enrollment")
    private List<Enrollment> index()
    {
        return enrollmentRepository.findAll();
    }

    @GetMapping("/enrollment/{id}")
    private Enrollment get(@PathVariable int id)
    {
        return enrollmentRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @PostMapping("/enrollment")
    private Enrollment create(@RequestBody HashMap<String, String> body)
    {
        int studentId = Integer.parseInt(body.get("studentId"));
        int courseId = Integer.parseInt(body.get("courseId"));
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new NotFoundException("Could not find student with the following ID:" + studentId));
        CourseUnit courseUnit = courseUnitRepository.findById(courseId).orElseThrow(() -> new NotFoundException("Could not find course unit with the following ID:" + courseId));
        System.out.println("Student: " + student);
        return enrollmentRepository.save(new Enrollment(student, courseUnit));
    }

    @PutMapping("/enrollment/{id}")
    private Enrollment update(@PathVariable int id, @RequestBody HashMap<String, String> body)
    {
        Enrollment enrollment = enrollmentRepository.findById(id).orElse(null);
        if(body.get("grade") != null && enrollment.getGrade() != Double.parseDouble(body.get("grade")))
            enrollment.setGrade(Double.parseDouble(body.get("grade")));
        if(body.get("attendancePercentage") != null && enrollment.getAttendancePercentage() != Double.parseDouble(body.get("attendancePercentage")))
            enrollment.setAttendancePercentage(Double.parseDouble(body.get("attendancePercentage")));
        return enrollmentRepository.save(enrollment);
    }

    @DeleteMapping("/enrollment/{id}")
    private boolean delete(@PathVariable int id)
    {
        enrollmentRepository.deleteById(id);
        return true;
    }
}
