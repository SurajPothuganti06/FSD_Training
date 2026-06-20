import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class EmployeeDAO {
    public void addEmployee(Employee emp) {
        Session session = Utility.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(emp);
        tx.commit();
        session.close();
    }
    public Employee getEmployee(int id) {
        Session session = Utility.getSessionFactory().openSession();
        Employee emp = session.get(Employee.class, id);
        session.close();
        return emp;
    }
    public List<Employee> getAllEmployees() {
        Session session = Utility.getSessionFactory().openSession();
        List<Employee> list = session.createQuery("from Employee", Employee.class).list();
        session.close();
        return list;
    }
    public void updateEmployee(int id, double salary) {
        Session session = Utility.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Employee emp = session.get(Employee.class, id);
        if(emp != null) {
            emp.setSalary(salary);
        }
        tx.commit();
        session.close();
    }
    public void deleteEmployee(int id) {
        Session session = Utility.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Employee emp = session.get(Employee.class, id);
        if(emp != null) {
            session.remove(emp);
        }
        tx.commit();
        session.close();
    }
}