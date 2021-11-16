package hibernateTest;

import hibernateTest.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            List<Student> students = session.createQuery("from Student").getResultList();

            System.out.println("All students");
            display(students);

            students = session.createQuery("from Student s where s.lastName = 'Wick'").getResultList();
            display(students);

            session.getTransaction().commit();
            System.out.println("Done");
        } catch (Exception e) { e.printStackTrace();
        } finally {
            factory.close();
        }
    }

    private static void display(List<Student> students){
        students.forEach(student -> System.out.println(student.toString()));
        System.out.println();
    }
}
