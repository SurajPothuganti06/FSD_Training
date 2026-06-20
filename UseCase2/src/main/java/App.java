import java.text.SimpleDateFormat;
import java.util.List;
public class App {
    public static void main(String[] args) throws Exception {
        EmployeeDAO dao = new EmployeeDAO();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Employee e1 = new Employee(102, "Suraj",  50000, "IT", sdf.parse("19-06-2026"));
        // CREATE
        dao.addEmployee(e1);
        // READ ONE
        System.out.println(dao.getEmployee(101));
        // UPDATE
        dao.updateEmployee(101, 65000);
        // READ ALL
        List<Employee> list = dao.getAllEmployees();
        for(Employee e : list) {
            System.out.println(e);
        }
//        // DELETE
//        dao.deleteEmployee(101);
    }
}