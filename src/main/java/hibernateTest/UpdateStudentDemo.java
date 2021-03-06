package hibernateTest;

import hibernateTest.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int id = 1;

            session.beginTransaction();

            Student myStudent = session.get(Student.class, id);

            myStudent.setFirstName("Someone");

            session.getTransaction().commit();
            System.out.println("Updating done");

            session = factory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("update Student set email='foo@gmail.com'")
                            .executeUpdate();

            session.getTransaction().commit();

        } catch (Exception e) { e.printStackTrace();
        } finally {
            factory.close();
        }
    }


}
