package studentenrollment;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Students")
public class Student {

    @Id
    @Column(name = "studentID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String email;
    private String phone;
    private String address;
    private char gender;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<Enrollment> enrollments;

    public Student() {}

    public Student(String name, String email, String phone, String address, char gender) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

}
