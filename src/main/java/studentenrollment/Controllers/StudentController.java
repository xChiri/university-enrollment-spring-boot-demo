package studentenrollment.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import studentenrollment.Models.Student;
import studentenrollment.NotFoundException;
import studentenrollment.Repositories.StudentRepository;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/student")
    public List<Student> index()
    {
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    public Student get(@PathVariable int id)
    {
        return studentRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @PostMapping("/student")
    public Student create(@RequestBody HashMap<String, String> body)
    {
        Student student = new Student();
        student.setName(body.get("name"));
        student.setEmail(body.get("email"));
        student.setPhone(body.get("phone"));
        student.setAddress(body.get("address"));
        student.setGender(body.get("gender").charAt(0));
        return studentRepository.save(student);
    }

    @PutMapping("/student/{id}")
    public Student update(@PathVariable int id, @RequestBody HashMap<String, String> body)
    {
        Student student = studentRepository.findById(id).orElse(null);
        if(student.getName().compareTo(body.get("name")) != 0)
            student.setName(body.get("name"));
        if(body.get("email") != null && student.getEmail().compareTo(body.get("email")) != 0)
            student.setEmail(body.get("email"));
        if(body.get("phone") != null && student.getPhone().compareTo(body.get("phone")) != 0)
            student.setPhone(body.get("phone"));
        if(body.get("address") != null && student.getAddress().compareTo(body.get("address")) != 0)
            student.setAddress(body.get("address"));
        return studentRepository.save(student);
    }

    @DeleteMapping("/student/{id}")
    public boolean delete(@PathVariable int id)
    {
        studentRepository.deleteById(id);
        return true;
    }
}
