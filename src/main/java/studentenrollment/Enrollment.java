package studentenrollment;

import javax.persistence.*;

@Entity
@Table(name = "Enrollments")
public class Enrollment {

    @Id
    @Column(name = "EnrollmentID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentID", referencedColumnName = "id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseUnitID", referencedColumnName = "id")
    private CourseUnit courseUnit;

    private double attendancePercentage;
    private double grade;

    public Enrollment() {}

    public Enrollment(Student student, CourseUnit courseUnit, double attendancePercentage, double grade) {
        this.student = student;
        this.courseUnit = courseUnit;
        this.attendancePercentage = attendancePercentage;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public CourseUnit getCourseUnit() {
        return courseUnit;
    }

    public void setCourseUnit(CourseUnit courseUnit) {
        this.courseUnit = courseUnit;
    }

    public double getAttendancePercentage() {
        return attendancePercentage;
    }

    public void setAttendancePercentage(double attendancePercentage) {
        this.attendancePercentage = attendancePercentage;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
