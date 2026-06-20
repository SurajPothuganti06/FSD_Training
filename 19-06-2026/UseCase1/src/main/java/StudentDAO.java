import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class StudentDAO {
    // CREATE
    public void saveStudent(Student student) {
        Session session = Utility.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(student);
        tx.commit();
        session.close();
    }
    // READ BY ID 
    public Student getStudent(int sid) {
        Session session = Utility.getSessionFactory().openSession();
        Student student = session.get(Student.class, sid);
        session.close();
        return student;
    }
    // READ ALL
    public List<Student> getAllStudents() {
        Session session = Utility.getSessionFactory().openSession();
        List<Student> students = session.createQuery("from Student", Student.class).list();
        session.close();
        return students;
    }
    // UPDATE
    public void updateStudent(Student student) {
        Session session = Utility.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(student);
        tx.commit();
        session.close();
    }
    // DELETE
    public void deleteStudent(int sid) {
        Session session = Utility.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Student student = session.get(Student.class, sid);
        if (student != null) {
            session.delete(student);
        }
        tx.commit();
        session.close();
    }
}