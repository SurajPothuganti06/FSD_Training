import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Student {
    @Id
    private int sid;
    private String sname;
    private String email;
    private String course;
    private int age;
    public Student() {
    }
    public Student(int sid, String sname, String email, String course, int age) {
        this.sid = sid;
        this.sname = sname;
        this.email = email;
        this.course = course;
        this.age = age;
    }
    public int getSid() {
        return sid;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
    public String getSname() {
        return sname;
    }
    public void setSname(String sname) {
        this.sname = sname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}