package studentenrollment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class CourseUnitController {

    @Autowired
    private CourseUnitRepository repository;

    @GetMapping("/courseunits")
    private List<CourseUnit> index()
    {
        return repository.findAll();
    }

    @GetMapping("/courseunits/{id}")
    private CourseUnit get(@PathVariable int id)
    {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    @PostMapping("/courseunits")
    private CourseUnit create(@RequestBody HashMap<String, String> body)
    {
        CourseUnit unit = new CourseUnit();
        unit.setName(body.get("name"));
        unit.setCode(Integer.parseInt(body.get("code")));
        unit.setCredits(Integer.parseInt(body.get("credits")));
        unit.setSchool(body.get("school"));
        unit.setSemester(Integer.parseInt(body.get("semester")));
        return repository.save(unit);
    }

    @PutMapping("/courseunits/{id}")
    public CourseUnit update(@PathVariable int id, @RequestBody HashMap<String, String> body)
    {
        CourseUnit unit = repository.findById(id).orElse(null);
        if(body.get("name") != null && unit.getName().compareTo(body.get("name")) != 0)
            unit.setName(body.get("name"));
        if(body.get("code") != null && unit.getCode() != Integer.parseInt(body.get("code")))
            unit.setCode(Integer.parseInt(body.get("code")));
        if(body.get("credits") != null && unit.getCredits() != Integer.parseInt(body.get("credits")))
            unit.setCredits(Integer.parseInt(body.get("credits")));
        if(body.get("school") != null && unit.getSchool().compareTo(body.get("school")) != 0)
            unit.setSchool(body.get("school"));
        if(body.get("semester") != null && unit.getSemester() != Integer.parseInt(body.get("semester")))
            unit.setSemester(Integer.parseInt(body.get("semester")));
        return repository.save(unit);
    }

    @DeleteMapping("/courseunits/{id}")
    private boolean delete(@PathVariable int id)
    {
        repository.deleteById(id);
        return true;
    }
}
