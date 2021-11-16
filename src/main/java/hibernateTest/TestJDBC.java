package hibernateTest;

import hibernateTest.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hibernate";
        String user = "hbstudent";
        String pass = "hbstudent";

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new object");
            Student student = new Student("Paul", "Wong", "paul@gmail.com");

            session.beginTransaction();

            System.out.println("Sending object to database");
            session.save(student);

            session.getTransaction().commit();
            System.out.println("Done");
        } catch (Exception e) { e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
