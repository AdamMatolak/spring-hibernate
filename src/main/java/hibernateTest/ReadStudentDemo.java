package hibernateTest;

import hibernateTest.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student student1 = new Student("Someone", "Else", "someone@gmail.com");
            session.beginTransaction();

            session.save(student1);
            System.out.println(student1);

            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();

            Student myStudent = session.get(Student.class, student1.getId());

            System.out.println("Get student: " + myStudent);

            session.getTransaction().commit();

            System.out.println("Done");

        } catch (Exception e) { e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
