package studentenrollment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
public class EnrollmentController {

    @Autowired
    private EnrollmentRepository repository;

    @GetMapping("/enrollment")
    private List<Enrollment> index()
    {
        return repository.findAll();
    }

    @GetMapping("/enrollment/{id}")
    private Enrollment get(@PathVariable int id)
    {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    @PostMapping("/enrollment")
    private Enrollment create(@RequestBody HashMap<String, String> body)
    {
        Enrollment enrollment = new Enrollment();
        enrollment.setGrade(Double.parseDouble(body.get("grade")));
        enrollment.setAttendancePercentage(Double.parseDouble(body.get("attendancePercentage")));
        return repository.save(enrollment);
    }

    @PutMapping("/enrollment/{id}")
    private Enrollment update(@PathVariable int id, @RequestBody HashMap<String, String> body)
    {
        Enrollment enrollment = repository.findById(id).orElse(null);
        if(body.get("grade") != null && enrollment.getGrade() != Double.parseDouble(body.get("grade")))
            enrollment.setGrade(Double.parseDouble(body.get("grade")));
        if(body.get("attendancePercentage") != null && enrollment.getAttendancePercentage() != Double.parseDouble(body.get("attendancePercentage")))
            enrollment.setAttendancePercentage(Double.parseDouble(body.get("attendancePercentage")));
        return repository.save(enrollment);
    }

    @DeleteMapping("/enrollment/{id}")
    private boolean delete(@PathVariable int id)
    {
        repository.deleteById(id);
        return true;
    }
}
