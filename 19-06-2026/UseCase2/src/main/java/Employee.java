import java.util.Date;
import jakarta.persistence.*;
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    private int eid;
    private String ename;
    private double salary;
    private String dept;
    @Temporal(TemporalType.DATE)
    private Date joiningDate;
    public Employee() {}
    public Employee(int eid, String ename, double salary, String dept, Date joiningDate) {
        this.eid = eid;
        this.ename = ename;
        this.salary = salary;
        this.dept = dept;
        this.joiningDate = joiningDate;
    }
    public int getEid() {
        return eid;
    }
    public void setEid(int eid) {
        this.eid = eid;
    }
    public String getEname() {
        return ename;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
    public Date getJoiningDate() {
        return joiningDate;
    }
    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }
    @Override
    public String toString() {
        return "Employee [eid="+eid+",ename="+ename+",salary="+salary+",dept="+dept+",joiningDate="+joiningDate +"]";
    }
}