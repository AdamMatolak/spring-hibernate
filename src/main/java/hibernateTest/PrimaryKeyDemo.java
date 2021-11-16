package hibernateTest;

import hibernateTest.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student student1 = new Student("Daniel", "Martinek", "danielmartinek@gmail.com");
            Student student2 = new Student("Jakub", "Deco", "jakubdeco@gmail.com");
            Student student3 = new Student("John", "Wick", "john@gmail.com");

            session.beginTransaction();

            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.getTransaction().commit();
            System.out.println("Done");
        } catch (Exception e) { e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
