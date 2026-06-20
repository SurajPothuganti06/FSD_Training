import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class Utility {
    private static SessionFactory factory;
    static {
        factory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
    }
    public static SessionFactory getSessionFactory() {
        return factory;
    }
}