package studentenrollment.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CourseUnits")
public class CourseUnit {

    @Id
    @Column(name = "CourseUnitID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int code;
    private int credits;
    private String school;
    private int semester;

    @OneToMany(mappedBy = "courseUnit", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Enrollment> enrollments;

    public CourseUnit() {}

    public CourseUnit(String name, int code, int credits, String school, int semester) {
        this.name = name;
        this.code = code;
        this.credits = credits;
        this.school = school;
        this.semester = semester;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
}
