import java.util.List;
public class App {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        // INSERT
        Student s1 = new Student(103, "Suraj", "suraj@gmail.com", "CSE", 21);
        dao.saveStudent(s1);
        System.out.println("Student Inserted");
        // READ
        Student s = dao.getStudent(101);
        System.out.println(s.getSid() + " " + s.getSname() + " " + s.getEmail() + " " + s.getCourse() + " " + s.getAge());
        // UPDATE
        s.setCourse("AI & ML");
        dao.updateStudent(s);
        System.out.println("Student Updated");
        // DISPLAY ALL
        List<Student> students = dao.getAllStudents();
        System.out.println("\nAll Students");
        for (Student st : students) {
            System.out.println(st.getSid() + " " + st.getSname() + " " + st.getEmail() + " " + st.getCourse() + " " + st.getAge());
        }
//        // DELETE
//        dao.deleteStudent(101);
//        System.out.println("Student Deleted");
        Utility.closeSessionFactory();
    }
}